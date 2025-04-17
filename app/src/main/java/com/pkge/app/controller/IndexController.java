package com.pkge.app.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class IndexController {
    @GetMapping("/")
    public String showIndexPage() {

        return "index";
    }
}