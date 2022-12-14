package xyz.nopalfi.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.nopalfi.blog.entity.Account;
import xyz.nopalfi.blog.entity.Post;
import xyz.nopalfi.blog.service.impl.AccountServiceImpl;
import xyz.nopalfi.blog.service.impl.PostServiceImpl;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Controller
public class WebController {

    private final AccountServiceImpl accountService;
    private final PostServiceImpl postService;

    @Autowired
    public WebController(AccountServiceImpl accountService, PostServiceImpl postService) {
        this.accountService = accountService;
        this.postService = postService;
    }

    @RequestMapping(value = "/")
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("posts", postService.getPosts());
        model.addAttribute("authName", auth.getName());
        return "index";
    }

    @RequestMapping(value = "post/{postId}")
    public String post(Model model, @PathVariable Long postId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("authName", auth.getName());
        model.addAttribute("post", postService.findById(postId));
        return "post";
    }

    @GetMapping(value = "/addpost")
    public String showPost(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("authName", auth.getName());
        Post post = new Post();
        post.setAccount(accountService.findByUsername(auth.getName()));
        model.addAttribute("post", post);
        return "addpost";
    }
    @PostMapping(value = "/updatepost/{id}")
    public String updatePostCommit(Post post, @PathVariable Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        post.setAccount(accountService.findByUsername(auth.getName()));
        postService.updatePost(id, post);
        return "redirect:/";
    }

    @GetMapping("/updatepost/{id}")
    public String updatePost(@PathVariable Long id, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Post post = postService.findById(id);
        model.addAttribute("authName", auth.getName());
        model.addAttribute("post", post);
        model.addAttribute("action", "edit");
        return "updatepost";
    }

    @PostMapping("/post")
    public String addPost(@ModelAttribute("post") Post post, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("post", post);
        post.setCreatedAt(ZonedDateTime.now(ZoneId.of("UTC")).toEpochSecond());
        Account nopalfi = accountService.findByUsername(auth.getName());
        post.setAccount(nopalfi);
        postService.addPost(post);
        return "redirect:/";
    }


    @GetMapping(value = "/deletepost/{postId}")
    public String deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String login(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.getName().equals("anonymousUser")) return "redirect:/";
        model.addAttribute("authName", auth.getName());
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logout() {
        return "redirect:/logout";
    }
}
