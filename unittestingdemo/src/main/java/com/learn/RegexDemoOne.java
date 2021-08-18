package com.learn;

import java.util.Arrays;

public class RegexDemoOne {

    public static void main(String[] args) {
        String text = "Hello0021342313214";

        System.out.println(text.matches("[A-Za-z]{5}[0-9]{2,}"));
        System.out.println(text.matches("\\w{5}\\d{2,}"));
        String fileRecord = "101,mike;100.25:delhi";

        String[] empDetails = fileRecord.split("[,;:]");
        System.out.println(Arrays.toString(empDetails));

        String code = "abcd";
        System.out.println(code.matches("([a-z]{3,}[0-9]+)|([A-Z]+)"));

        String spChar = "#";
        System.out.println(spChar.matches("^[\\W]$"));

    }


}
