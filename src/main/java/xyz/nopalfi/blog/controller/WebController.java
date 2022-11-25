package xyz.nopalfi.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.nopalfi.blog.service.impl.RestClientServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class WebController {

    @Autowired
    private RestClientServiceImpl restClientService;

    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("posts", restClientService.findAll());
        LocalDateTime localDateTime = LocalDateTime.now();
        return "index";
    }
}
