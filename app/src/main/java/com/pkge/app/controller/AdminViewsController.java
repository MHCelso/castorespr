package com.pkge.app.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminViewsController {
    @GetMapping("/register")
    public String showRegisterPage() {

        return "adregister";
    }
}
