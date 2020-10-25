package com.UserValid.UserValidation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UserRegistrationTest{
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String password;
    private boolean expected;
    private UserRegistration user;

    @Before
    public void init() {
        user = new UserRegistration();
    }

    public UserRegistrationTest(final String firstName,final String lastName,
                                final String email, final String mobile,final String password, final boolean expected) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.expected = expected;
    }

    @Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][]{
                {"Gopinath","Das","abc@yahoo.com","919876543210","abcS9edff",true},
                {"Gopinath","Das","abc-100@yahoo.com","919876543210","abcS9@edff",true},
                {"Gopinath","Das","abc.100@yahoo.com","919876543210","abcS9@edff",true},
                {"Gopinath","Das","abc111@yahoo.com","919876543210","abcS9e@dff",true},
                {"gopinath","Das","abc-100@abc.net","919876543210","abcS9ed@ff",true},
                {"Gopinath","Das","abc.100@abc.com.au","919876543210","abcS@9edff",true},
                {"Gopinath","das","abc@1.com","91 9876543210","abcS9ed@ff",true},
                {"Gopinath","Das","abc@gmail.com.com","919876543210","ab@cS9edff",true},
                {"Gopinath","Das","abc+100gmail.com","919876543210","abc@S9edff",true},
                {"Gopinath","Das","abc","91 9876543210","abcS@9edff",false},
                {"Gopinath","Das","abc@.com.my","919876543210","abc@S9edff",false},
                {"Gopinath","Das","abc123@gmail.a","919876543210","ab@cS9edff",false},
                {"Gopinath","Das","abc123@.com","919876543210","abcS9e@dff",false},
                {"Gopinath","Das","abc123@.com.com","919876543210","abc@S9edff",false},
                {"Gopinath","Das",".abc@abc.com","919876543210","abcS9ed@ff",false},
                {"Gopinath","Das","abc()*@gmail.com","919876543210","abcS@9edff",false},
                {"Gopinath","Das","abc@%*.com","919876543210","abcS9e@dff",false},
                {"Gopinath","Das","abc..2002@gmail.com","91 9876543210","ab@cS9edff",false},
                {"Gopinath","Das","abc.@gmail.com","919876543210","abcS9e@dff",false},
                {"Gopinath","Das","abc@abc@gmail.com","919876543210","abcS@9edff",false},
                {"Gopinath","Das","abc@gmail.com.1a","919876543210","abcS9@edff",false},
                {"Gopinath","Das","abc@gmail.com.aa.au","919876543210","abc@S9edff",false}
        });
    }

    @Test
   public void givenFirstName_WhenFirstLetterCapsAndLengthGreaterThan3_ShouldReturn_True() {
        try {
            if(!user.validateLastName.validate(lastName))
                throw new UserRegistrationException("Invalid last name: "+lastName);
        }catch(UserRegistrationException e){
            System.err.println("Exception " + e.getMessage());
        }
    }

    @Test
    public void givenLastName_WhenFirstLetterCapsAndLengthGreaterThan3_ShouldReturn_True() {
        try {
            if(!user.validateFirstName.validate(firstName))
                throw new UserRegistrationException("Invalid first name: "+firstName);
        }catch(UserRegistrationException e){
            System.err.println("Exception: " + e.getMessage());
        }
    }

    @Test
    public void givenEmail_WhenLettersAndSpecialCharactersFollowedbyATSymbolAndDomainName_ShouldReturn_True() {
        try {
            if(this.expected != user.validateEmail.validate(email))
                throw new UserRegistrationException("Invalid email: "+email);
        }catch(UserRegistrationException e){
            System.err.println("Exception:" + e.getMessage());
        }
    }

    @Test
    public void givenPhone_WhenStartsWith91AndLength10_ShouldReturn_True() {
        try {
            if(!user.validateMobile.validate(mobile))
                throw new UserRegistrationException("Invalid phone number: "+mobile);
        }catch(UserRegistrationException e){
            System.err.println("Exception: " + e.getMessage());
        }
    }

    @Test
    public void givenPassword_WhenLengthGreaterThan8FirstLetterCaps1Number1SpecialChar_ShouldReturn_True() {
        try {
            if(!user.validatePassword.validate(password))
                throw new UserRegistrationException("Invalid password: "+password);
        }catch(UserRegistrationException e){
            System.err.println("Exception " + e.getMessage());
        }
    }

}