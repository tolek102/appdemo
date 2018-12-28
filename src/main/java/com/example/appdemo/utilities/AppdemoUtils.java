package com.example.appdemo.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppdemoUtils {

    public static boolean checkEmailOrPassword(String pattern, String stringToCheck){

        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(stringToCheck);
        return matcher.matches();
    }
}
