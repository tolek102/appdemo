package com.example.appdemo.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.appdemo.Constants.AppDemoConstants;
import com.example.appdemo.User.User;
import com.example.appdemo.utilities.AppdemoUtils;

public class UserRegisterValidator implements Validator {

    @Override
    public boolean supports(Class<?> cls){
        return User.class.equals(cls);
    }

    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;

        ValidationUtils.rejectIfEmpty(errors, "name", "error.userName.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "error.userLastName.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "error.userPassword.empty");

        //TODO use && with 2 conditions in one if statement
        if (!user.getEmail().equals(null)){
            if (!AppdemoUtils.checkEmailOrPassword(AppDemoConstants.EMAIL_PATTERN, user.getEmail())) {
                errors.rejectValue("email", "error.userEmailIsNotMatch");
            }
        }

        //TODO use && with 2 conditions in one if statement
        if (!user.getPassword().equals(null)){
            if (!AppdemoUtils.checkEmailOrPassword(AppDemoConstants.PASSWORD_PATTERN, user.getPassword())) {
                errors.rejectValue("password", "error.userPasswordIsNotMach");
            }
        }
    }

    public void validateEmailExist(User user, Errors errors){
        if (user != null) {
            errors.rejectValue("email", "error.userEmailExist");
        }
    }
}
