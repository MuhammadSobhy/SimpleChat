package com.jwdnd.simplechat.controller;

import com.jwdnd.simplechat.model.User;
import com.jwdnd.simplechat.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SingUpController {

    UserService userService;

    public SingUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getSignupPage(User user , Model model) {
       return "signup";
    }

    @PostMapping
    public String signUp(User user , Model model) {
        userService.createUser(user);
        model.addAttribute("signupSuccess",true);
        return "signup";
    }
}
