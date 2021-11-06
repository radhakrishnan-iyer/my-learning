package com.learning.extra;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HowManyWords {
    public static void main(String[] args) {
        System.out.println(count("How many eggs are in a half-dozen,,,    13?"));
    }

    public static int count(String s) {
        String[] arr = s.split(" ");
        int count = 0;
        for(int i=0;i<arr.length;i++) {
            String str = arr[i].trim();
            if(str.equals(""))
                continue;
            /*if(str.equals(""))
                continue;
            Pattern p = Pattern.compile("[A-Za-z]*[-]*[A-Za-z]*[,!?. ]*");
            Matcher m = p.matcher(str);
            if(m.matches()) {
                System.out.println(str);
                count++;
            }*/
            boolean found = false;
            int j=0;
            for(;j<str.length();j++) {
                char c = str.charAt(j);
                if(c>='0' && c<='9')
                    break;
                if(c>='a' || c<='z' || c>='A' || c<='Z' || c=='-')
                    continue;
                if(c=='.' || c=='?' || c=='!'  || c==',')
                {
                    found = true;
                    break;
                }
                break;
            }
            if(j==str.length() || found) {
                System.out.println(str);
                count++;
            }
        }
        return count;
    }
}
