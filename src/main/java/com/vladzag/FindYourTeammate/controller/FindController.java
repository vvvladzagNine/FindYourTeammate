package com.vladzag.FindYourTeammate.controller;



import com.vladzag.FindYourTeammate.domain.Game;
import com.vladzag.FindYourTeammate.domain.Games;
import com.vladzag.FindYourTeammate.domain.User;
import com.vladzag.FindYourTeammate.domain.VoiceChats;
import com.vladzag.FindYourTeammate.repos.UserRepo;
import com.vladzag.FindYourTeammate.service.FindService;
import com.vladzag.FindYourTeammate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Controller
public class FindController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FindService findService;

    @GetMapping("/finder")
    public String after(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        model.addAttribute("gamesToAdd", Games.getStringValues());
        model.addAttribute("voicesToAdd", VoiceChats.getStringValues());
        model.addAttribute("me", user);
        model.addAttribute("users",userService.findAll());
        return "finder";
    }

    @PostMapping("/finder")
    public String find(
            @AuthenticationPrincipal User user,
            @RequestParam(value = "oldFrom",required = false) String oldFrom,
            @RequestParam(value = "oldTo",required = false) String oldTo,
            @RequestParam(value = "male",required = false) String male,
            @RequestParam(value = "female",required = false) String female,
            @RequestParam(value = "gameName",required = false)String gameName,
            @RequestParam(value = "skill",required = false)String skill,
            @RequestParam(value = "username",required = false)String name,
            Model model
    ) {

        List<User> users = findService.find(user,oldFrom,oldTo,male,female,gameName,skill,name);

        model.addAttribute("gamesToAdd", Games.getStringValues());
        model.addAttribute("voicesToAdd", VoiceChats.getStringValues());
        model.addAttribute("me", user);
        model.addAttribute("users",users);
        return "finder";
    }

}
