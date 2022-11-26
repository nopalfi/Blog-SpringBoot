package xyz.nopalfi.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.nopalfi.blog.entity.Account;
import xyz.nopalfi.blog.entity.Post;
import xyz.nopalfi.blog.service.impl.AccountServiceImpl;
import xyz.nopalfi.blog.service.impl.RestClientServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class WebController {

    @Autowired
    private RestClientServiceImpl restClientService;

    @Autowired
    private AccountServiceImpl accountService;

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

    @RequestMapping(value = "/addpost")
    public String addPost(Model model) {
        model.addAttribute("post", new Post());
        return "addpost";
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

    @PostMapping(value = "/updatepost", params = "action=edit")
    public String updatePost(@ModelAttribute("post") Post post, Model model) {
        model.addAttribute("post", post);
        return "addpost";
    }

    @PostMapping(value = "/deletepost", params = "action=delete")
    public String deletePost(@ModelAttribute("post") Post post, Model model) {
        model.addAttribute("post", post);
        return "redirect:/";
    }
}
