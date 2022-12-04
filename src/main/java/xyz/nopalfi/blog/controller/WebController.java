package xyz.nopalfi.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.nopalfi.blog.entity.Account;
import xyz.nopalfi.blog.entity.Post;
import xyz.nopalfi.blog.service.impl.AccountServiceImpl;
import xyz.nopalfi.blog.service.impl.PostServiceImpl;
import xyz.nopalfi.blog.service.impl.RestClientServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

@Controller
public class WebController {

    @Autowired
    private RestClientServiceImpl restClientService;

    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private PostServiceImpl postService;

    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("posts", restClientService.findAll());
        LocalDateTime localDateTime = LocalDateTime.now();
        return "index";
    }

    @RequestMapping(value = "post/{postId}")
    public String post(Model model, @PathVariable Long postId) {
        model.addAttribute("post", restClientService.findById(postId));
        return "post";
    }

    @GetMapping(value = "/addpost")
    public String addPost(Model model) {
        model.addAttribute("post", new Post());
        return "addpost";
    }
    @PostMapping(value = "/updatepost/{id}")
    public String updatePostCommit(Post post, @PathVariable Long id, Model model) {
        Account nopalfi = accountService.findByUsername("nopalfi");
        post.setAccount(nopalfi);
        postService.updatePost(id, post);
        return "redirect:/";
    }

    @GetMapping("/updatepost/{id}")
    public String updatePost(@PathVariable Long id, Model model) {
        Post post = restClientService.findById(id);
        model.addAttribute("post", post);
        model.addAttribute("action", "edit");
        return "updatepost";
    }

    @PostMapping("/post")
    public String post(@ModelAttribute("post") Post post, Model model) {
        model.addAttribute("post", post);
        post.setCreatedAt(LocalDateTime.now());
        Account nopalfi = accountService.findByUsername("nopalfi");
        post.setAccount(nopalfi);
        restClientService.addPost(post);
        return "redirect:/";
    }


    @GetMapping(value = "/deletepost/{postId}")
    public String deletePost(@PathVariable Long postId, Model model) {
        postService.deletePost(postId);
        return "redirect:/";
    }
}
