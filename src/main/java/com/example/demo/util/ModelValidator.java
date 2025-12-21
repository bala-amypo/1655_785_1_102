package com.example.demo.util;

import java.util.regex.Pattern;

public class ModelValidator {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private ModelValidator() {
        // private constructor to prevent instantiation
    }

    // Check if string is null or empty
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Validate email format
    public static boolean isValidEmail(String email) {
        if (isNullOrEmpty(email)) return false;
        return EMAIL_PATTERN.matcher(email).matches();
    }

    // Validate string length
    public static boolean isValidLength(String str, int min, int max) {
        if (isNullOrEmpty(str)) return false;
        int length = str.trim().length();
        return length >= min && length <= max;
    }

    // Validate password: minimum 6 chars, at least one digit
    public static boolean isValidPassword(String password) {
        if (isNullOrEmpty(password)) return false;
        return password.length() >= 6 && password.matches(".*\\d.*");
    }
}
