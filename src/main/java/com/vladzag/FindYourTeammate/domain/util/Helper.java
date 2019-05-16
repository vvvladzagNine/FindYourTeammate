package com.vladzag.FindYourTeammate.domain.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Helper {
    public static Set<String> getStrings(Object[] values) {
        Set<String> stringVoice = new HashSet<>();
        Arrays.stream(values).forEach(en->{
            String str = en.toString();
            String[] strs = str.split("_");
            str="";
            for(int i=0;i<strs.length;i++){
                str+=strs[i];
                if(i != (strs.length-1))str+=" ";
            }
            stringVoice.add(str);
        });
        return stringVoice;
    }
}
