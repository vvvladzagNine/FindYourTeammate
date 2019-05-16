package com.vladzag.FindYourTeammate.service;

import com.vladzag.FindYourTeammate.domain.Game;
import com.vladzag.FindYourTeammate.domain.Role;
import com.vladzag.FindYourTeammate.domain.User;
import com.vladzag.FindYourTeammate.domain.VoiceChat;
import com.vladzag.FindYourTeammate.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(s);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public boolean addUser(User user){
        User user1 = userRepo.findByUsername(user.getUsername());
        if(user1!=null){
            return false;
        }
        System.out.println(user.getPassword());
        user.setRoles(Collections.singleton(Role.USER));
        String p = user.getPassword();
        user.setPassword(passwordEncoder.encode(p));
        user.setActive(true);
        userRepo.save(user);
        return true;

    }

    public void addGame(User user,String gameNam,String skill,String exp){
        Set<Game> games = user.getGames();
        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()){
            Game game = iterator.next();
            if(gameNam.equals(game.getGameName())){
                iterator.remove();
            }
        }
        Game g = new Game(gameNam,skill,exp);
        games.add(g);
        user.setGames(games);
        userRepo.save(user);
    }

    public boolean saveProfile(){
        return false;
    }

    public void addVoice(User user, String gameVoice, String nick) {
        Set<VoiceChat> voices = user.getVoiceChats();
        Iterator<VoiceChat> iterator = voices.iterator();
        while (iterator.hasNext()) {
            VoiceChat voice = iterator.next();
            if(gameVoice.equals(voice.getVoiceName())){
                iterator.remove();
            }
        }
        VoiceChat g= new VoiceChat(gameVoice,nick);
        voices.add(g);
        user.setVoiceChats(voices);
        userRepo.save(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }
}
