package com.UserValid.UserValidation;

import java.util.function.Predicate;
import java.util.regex.Pattern;
@FunctionalInterface
interface UserValidator {
    boolean validate(String s);
}
public class UserRegistration {
    private static final String NAME ="^[A-Z][a-z]{2,}$";
    private static final String EMAIL =  "^[a-zA-Z0-9|_|-][a-zA-Z0-9|_|-|\\+]*(\\.)?[a-zA-Z0-9|_|-]{1,}\\@[0-9a-zA-Z]{1,}\\.[a-zA-Z]{2,}(\\.)?[a-zA-Z]*$";
    private static final String PHONE = "^[0-9]{2}[0-9]{10}";
    private static final String PASSWORD = "(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%!]).{8,40}";

    public boolean validateFirstName (String name){
        Pattern regex=Pattern.compile(NAME);
        Predicate<String> predicate=regex.asPredicate();
        return predicate.test(name);
    }
    public boolean validateLastName (String name){
        Pattern regex=Pattern.compile(NAME);
        Predicate<String> predicate=regex.asPredicate();
        return predicate.test(name);
    }
    public boolean validateEmail (String name){
        Pattern regex=Pattern.compile(EMAIL);
        Predicate<String> predicate=regex.asPredicate();
        return predicate.test(name);
    }
    public boolean validatePhone (String name){
        Pattern regex=Pattern.compile(PHONE);
        Predicate<String> predicate=regex.asPredicate();
        return predicate.test(name);
    }
    public boolean validatePassword (String name){
        Pattern regex=Pattern.compile(PASSWORD);
        Predicate<String> predicate=regex.asPredicate();
        return predicate.test(name);
    }
}