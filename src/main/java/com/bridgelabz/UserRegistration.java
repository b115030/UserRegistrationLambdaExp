package com.bridgelabz;

import java.util.regex.Pattern;

public class UserRegistration {
    private static final String NAME ="^[A-Z][a-z]{2,}$";
    private static final String EMAIL =  "^[a-zA-Z0-9|_|-][a-zA-Z0-9|_|-|\\+]*(\\.)?[a-zA-Z0-9|_|-]{1,}\\@[0-9a-zA-Z]{1,}\\.[a-zA-Z]{2,}(\\.)?[a-zA-Z]*$";
    private static final String PHONE = "^[0-9]{2}[0-9]{10}";
    private static final String PASSWORD = "(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%!]).{8,40}";
    UserValidator validateFirstName = (s) -> (Pattern.compile(NAME).matcher(s).matches());
    UserValidator validateLastName = (s) -> (Pattern.compile(NAME).matcher(s).matches());
    UserValidator validateEmail = (s) -> (Pattern.compile(EMAIL).matcher(s).matches());
    UserValidator validateMobile = (s) -> (Pattern.compile(PHONE).matcher(s).matches());
    UserValidator validatePassword = (s) -> (Pattern.compile(PASSWORD).matcher(s).matches());

    public boolean validateFirstName(String firstName){
        return firstName.matches(NAME);
    }
    public boolean validateLastName(String lastName){
        return lastName.matches(NAME);
    }
    public boolean validateEmail(String email){
        return email.matches(EMAIL);
    }
    public boolean validatePhone(String phone){
        return phone.matches(PHONE);
    }
    public boolean validatePassword(String password){
        return password.matches(PASSWORD);
    }
    @FunctionalInterface
    interface UserValidator {
        boolean validate(String s);
    }
}
