package com.pkge.app.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/public")
@RequiredArgsConstructor
public class PublicController {
    @GetMapping("/index")
    public String showIndexPage() {

        return "index";
    }

    @GetMapping("/home")
    public String showHomePage() {

        return "home";
    }
}