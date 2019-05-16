package com.vladzag.FindYourTeammate.controller;

import com.vladzag.FindYourTeammate.domain.Games;
import com.vladzag.FindYourTeammate.domain.User;
import com.vladzag.FindYourTeammate.domain.VoiceChats;
import com.vladzag.FindYourTeammate.repos.UserRepo;
import com.vladzag.FindYourTeammate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/user/{user}")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Value("${upload.path}")
    private String uploadPath;


    @GetMapping("")
    public String profile(
            Model model,
            @PathVariable(name = "user") User user,
            @AuthenticationPrincipal User currentUser

    ) {

        model.addAttribute("user", user);
        model.addAttribute("me", currentUser);
        model.addAttribute("isMyProfile", currentUser.equals(user));
        model.addAttribute("gamesToAdd", Games.getStringValues());
        model.addAttribute("voicesToAdd", VoiceChats.getStringValues());

        return "myProfile";
    }

    @GetMapping("/edit")
    public String editProfile(
            Model model,
            @PathVariable(name = "user") User user,
            @AuthenticationPrincipal User currentUser
    ) {
        if (currentUser.equals(user)) {
            model.addAttribute("user", user);
            return "myProfileEdit";
        } else return "redirect:/user/{user}";

    }

    @PostMapping("/edit")
    public String saveProfile(
            Model model,
            @PathVariable(name = "user") User user,
            @AuthenticationPrincipal User currentUser,
            @RequestParam("file") MultipartFile file,
            @RequestParam("username") String username,
            @RequestParam("old") String old,
            @RequestParam("about") String about,
            @RequestParam("email") String email,
            @RequestParam(value = "exampleRadios", required = false) String mf
    ) throws IOException {
        if (currentUser.equals(user)) {
            model.addAttribute("user", user);

            if (file != null && !file.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(uploadPath);

                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                String uuidFile = UUID.randomUUID().toString();
                String resultFilename = uuidFile + "." + file.getOriginalFilename();

                file.transferTo(new File(uploadPath + "/" + resultFilename));

                user.setAva(resultFilename);
            }
            String oldError;
            try{
                int o =Integer.parseInt(old);
                user.setOld(o);
            }catch (NumberFormatException e){
                oldError="incorrect data: 'old'!";
            }
            if(about!=null && about!= "" && !about.isEmpty())
                user.setAbout(about);
            user.setUsername(username);
            user.setEmail(email);
            if(mf!=null && (mf.equals("M") || mf.equals("F"))){
                boolean b =mf.equals("M");
                user.setSex(b);
            }
            else {
                user.setSex(null);
            }

            userRepo.save(user);
            return "redirect:/user/{user}";


        }
        else return "redirect:/user/{user}";
    }

    @PostMapping(params={"gameName","skill","experience"})
    public String addGame (
            Model model,
            @PathVariable(name = "user") User user,
            @AuthenticationPrincipal User currentUser,
            @RequestParam("gameName") String gameName,
            @RequestParam("skill") String skill,
            @RequestParam("experience") String experience
    ) {
         if (currentUser.equals(user)) {
            /*
            String g = gameName + "/" + skill + "/" + experience;
            Set<String> s = user.getGames();
            s.add(g);
            user.setGames(s);
            userRepo.save(user);
            */
            userService.addGame(user,gameName,skill,experience);
            model.addAttribute("user", user);
            model.addAttribute("me", currentUser);
            model.addAttribute("isMyProfile", currentUser.equals(user));
            model.addAttribute("gamesToAdd", Games.getStringValues());
            model.addAttribute("voicesToAdd", VoiceChats.getStringValues());
            return "myProfile";
        } else return "redirect:/";

    }

    @PostMapping(params={"gameVoice","nick"})
    public String addVoice (
            Model model,
            @PathVariable(name = "user") User user,
            @AuthenticationPrincipal User currentUser,
            @RequestParam("gameVoice") String gameVoice,
            @RequestParam("nick") String nick

    ) {
        if (currentUser.equals(user)) {
            userService.addVoice(user,gameVoice,nick);
            model.addAttribute("user", user);
            model.addAttribute("me", currentUser);
            model.addAttribute("isMyProfile", currentUser.equals(user));
            model.addAttribute("gamesToAdd", Games.getStringValues());
            model.addAttribute("voicesToAdd", VoiceChats.getStringValues());
            return "myProfile";
        } else return "redirect:/";

    }
}
