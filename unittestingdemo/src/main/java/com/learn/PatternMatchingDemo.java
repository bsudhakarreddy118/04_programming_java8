package com.learn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchingDemo {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\d+");
        String text = "abcd123fgh4ijk9999";
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.matches());
        while(matcher.find()){
            System.out.println(matcher.group());
            System.out.println(matcher.start() + " - " + matcher.end());
        }
    }
}
