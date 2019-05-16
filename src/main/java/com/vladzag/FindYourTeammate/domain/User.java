package com.vladzag.FindYourTeammate.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="usr")
public class User implements UserDetails{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String about;
    private Integer old;
    private Boolean sex;
    private String ava;


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User(String username, String password, boolean active, String email) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.email = email;
    }

    public User() {
    }

    @ElementCollection(targetClass = String.class,fetch =FetchType.EAGER)
    @CollectionTable(name="user_photos",joinColumns = @JoinColumn(name="user_id"))
    private Set<String> photos;

    @ElementCollection(targetClass = Role.class,fetch =FetchType.EAGER)
    @CollectionTable(name="user_role",joinColumns = @JoinColumn(name="user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @ElementCollection(targetClass = Game.class,fetch =FetchType.LAZY)
    @CollectionTable(name="GAME",joinColumns = @JoinColumn(name="user_id"))
    private Set<Game> games;


    /*
          ()()()()()()()()()()()()()()()
     */
        //TODO почитать документацию про эти аннотации
    /*
        ()()()()()()()()()()()()()()()()
     */
    @ElementCollection(targetClass = VoiceChat.class,fetch =FetchType.LAZY)
    @CollectionTable(name="voice",joinColumns = @JoinColumn(name="user_id"))
    private Set<VoiceChat> voiceChats;

    public Boolean getSex() {
        return sex;
    }
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Set<VoiceChat> getVoiceChats() {
        return voiceChats;
    }

    public void setVoiceChats(Set<VoiceChat> voiceChats) {
        this.voiceChats = voiceChats;
    }


    @NotBlank(message = "Username cannot me empty")
    private String username;
    @NotBlank(message = "Password cannot me empty")
    private String password;

    private boolean active;
    @Email(message = "Email is not correct")
    @NotBlank(message = "Email cannot me empty")
    private String email;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {

        return id;
    }


    public boolean isActive() {
        return active;
    }

    public boolean isAdmin(){
        return roles.contains(Role.ADMIN);
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(obj==null || getClass()!= obj.getClass())return false;
        User user = (User)obj;
        return Objects.equals(id,user.id);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }



    public String getAva() {
        return ava;
    }

    public void setAva(String ava) {
        this.ava = ava;
    }

    public Set<String> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<String> photos) {
        this.photos = photos;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }


}
