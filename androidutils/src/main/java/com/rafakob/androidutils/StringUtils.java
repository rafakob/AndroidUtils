package com.rafakob.androidutils;

public class StringUtils {
    public static String capitalize(String input) {
        return input.substring(0, 1).toUpperCase().concat(input.substring(1));
    }
}
