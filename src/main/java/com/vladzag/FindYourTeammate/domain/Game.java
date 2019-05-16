package com.vladzag.FindYourTeammate.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Game {
    private String gameName;
    private String skill;
    private String experience;

    public Game(String gameName, String skill, String experience) {
        this.gameName = gameName;
        this.skill = skill;
        this.experience = experience;
    }

    public Game() {
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
