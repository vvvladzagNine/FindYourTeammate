package com.vladzag.FindYourTeammate.domain;

import javax.persistence.Embeddable;

@Embeddable
public class VoiceChat {
    private String voiceName;
    private String nick;

    public VoiceChat() {
    }

    public VoiceChat(String voiceName, String nick) {
        this.voiceName = voiceName;
        this.nick = nick;
    }

    public String getVoiceName() {
        return voiceName;
    }

    public void setVoiceName(String voiceName) {
        this.voiceName = voiceName;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
