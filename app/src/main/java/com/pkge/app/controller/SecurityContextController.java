package com.pkge.app.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SecurityContextController {

    @GetMapping("/security")
    public String getSecurityContextData() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {

            return authentication.getName();
        } else {

            return "No user logged in";
        }
    }
}
