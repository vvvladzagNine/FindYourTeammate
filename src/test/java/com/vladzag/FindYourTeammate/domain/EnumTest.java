package com.vladzag.FindYourTeammate.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class EnumTest {

    @Test
    public void getStringValues() {
        Set<String> set = new HashSet<>();
        set.add("Discord");
        set.add("Team speak");
        set.add("Skype");
        set.add("Raid call");
        Set<String> setExp = VoiceChats.getStringValues();
        Assert.assertArrayEquals(setExp.toArray(),set.toArray());

    }
}