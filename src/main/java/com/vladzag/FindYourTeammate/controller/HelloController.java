package com.vladzag.FindYourTeammate.controller;



import com.vladzag.FindYourTeammate.domain.Games;
import com.vladzag.FindYourTeammate.domain.User;
import com.vladzag.FindYourTeammate.domain.VoiceChats;
import com.vladzag.FindYourTeammate.repos.UserRepo;
import com.vladzag.FindYourTeammate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class HelloController {



    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;




    @GetMapping("/")
    public String greeting() {
        return "hello";
    }



    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            @RequestParam("password2") String passwordConfirm,
            @Valid User user,
            BindingResult bindingResult,
            Model model

    ) {


        if(user.getPassword()!=null && !user.getPassword().equals(passwordConfirm)){
            model.addAttribute("passwordError","Passwords are different");
            return "registration";
        }

        if(bindingResult.hasErrors()){
            return "registration";
        }

        if (!userService.addUser(user)) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        return "redirect:/login";
    }


}

