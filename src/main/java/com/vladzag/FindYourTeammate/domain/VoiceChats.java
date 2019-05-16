package com.vladzag.FindYourTeammate.domain;

import java.util.Set;

import static com.vladzag.FindYourTeammate.domain.util.Helper.getStrings;

public enum VoiceChats {
    Discord,Team_speak,Skype,Raid_call;
    public static Set<String> getStringValues(){
        VoiceChats[] values = VoiceChats.values();
        return getStrings(values);

    }
}
