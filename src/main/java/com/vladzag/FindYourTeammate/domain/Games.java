package com.vladzag.FindYourTeammate.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.vladzag.FindYourTeammate.domain.util.Helper.getStrings;

public enum Games {
    Dota_2,CS_GO,Minecraft,OverWatch,Leage_of_Legends,World_of_Warcraft,World_of_Tanks;

    public static Set<String> getStringValues(){
        Games[] values = Games.values();
        return getStrings(values);

    }

}
