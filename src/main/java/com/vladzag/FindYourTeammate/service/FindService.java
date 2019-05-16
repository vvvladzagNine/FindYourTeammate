package com.vladzag.FindYourTeammate.service;

import com.vladzag.FindYourTeammate.domain.Game;
import com.vladzag.FindYourTeammate.domain.Games;
import com.vladzag.FindYourTeammate.domain.User;
import com.vladzag.FindYourTeammate.domain.VoiceChats;
import com.vladzag.FindYourTeammate.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class FindService {

    @Autowired
    private UserRepo userRepo;

    public List<User> find(User user, String oldFrom, String oldTo, String male,
                            String female,String gameName, String skill, String name){
        List<User> users;

        if(name!=null && name!="" && !name.isEmpty()){
            if(userRepo.findByUsername(name)!=null) {
                users = new ArrayList<>();
                users.add(userRepo.findByUsername(name));
                return users;
            }

        }
        int oldF=-5;
        boolean isOldFromNumber;
        try{
            oldF=Integer.parseInt(oldFrom);
            isOldFromNumber=true;
        }catch (NumberFormatException e){
            isOldFromNumber=false;
        }

        int oldT=9999;
        boolean isOldToNumber;
        try{
            oldT=Integer.parseInt(oldTo);
            isOldToNumber=true;
        }catch (NumberFormatException e){
            isOldToNumber=false;
        }
        users = userRepo.findAll();
        if(isOldFromNumber){
            if(isOldToNumber){
                users = userRepo.findAllByOldGreaterThanAndOldLessThan(oldF,oldT);
            }
            else
                users = userRepo.findAllByOldGreaterThan(oldF);
        } else if (oldTo!=null && oldTo!="" && !oldTo.isEmpty() && isOldToNumber) {
            users=userRepo.findAllByOldLessThan(oldT);
        }
        boolean m = (male!=null);
        boolean f = (female!=null);
        if(!m || !f){
            if(m){
                Iterator<User> it = users.iterator();
                while(it.hasNext()){
                    User u = it.next();
                    if(!u.getSex())it.remove();
                }
            }
            else if(f){
                Iterator<User> it = users.iterator();
                while(it.hasNext()){
                    User u = it.next();
                    if(u.getSex())it.remove();
                }
            }
        }
        if(gameName!=null && gameName!= "" && !gameName.isEmpty()){
            boolean skillMatters = (skill!=null && skill!= "" && !skill.isEmpty());
            Iterator<User> it = users.iterator();
            while(it.hasNext()){
                boolean willDeleted=true;
                User u = it.next();
                if(u.getGames()!=null)
                    for(Game g : u.getGames()){
                        if(g.getGameName().equals(gameName)){
                            if(skillMatters){
                                if(g.getSkill().equals(skill)){
                                    willDeleted=false;
                                }
                                else{
                                }
                            }
                            else {
                                willDeleted=false;
                            }
                        }
                    }
                if(willDeleted)it.remove();
            }
        }
        return users;
    }
}
