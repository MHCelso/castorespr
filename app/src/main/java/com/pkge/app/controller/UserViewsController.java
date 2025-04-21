package com.pkge.app.controller;


import com.pkge.app.entity.User;
import com.pkge.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping("/user")
public class UserViewsController {
    private final UserRepository userRepository;

    public UserViewsController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/update")
    public String showUserUpdatePage(Model model) {
        SecurityContextController securityController = new SecurityContextController();
        String userName = securityController.getSecurityContextData();

        User user = userRepository.findByUsername(userName);
        model.addAttribute("user", user);

        return "usupdate";
    }
}
