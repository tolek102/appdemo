package com.example.appdemo.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.appdemo.Constants.AppDemoConstants;
import com.example.appdemo.User.User;
import com.example.appdemo.utilities.AppdemoUtils;

public class ChangePasswordValidator implements Validator {

    @Override
    public boolean supports(final Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(final Object o, final Errors errors) {
        @SuppressWarnings("unused")
        User u = (User) o;

        ValidationUtils.rejectIfEmpty(errors, "newPassword", "error.userPassword.empty");
    }

    public void checkPasswords(String newPass, Errors errors) {

        if (!newPass.equals(null)) {
            boolean isMatch = AppdemoUtils.checkEmailOrPassword(AppDemoConstants.PASSWORD_PATTERN, newPass);
            if(!isMatch) {
                errors.rejectValue("newPassword", "error.userPasswordIsNotMatch");
            }
        }
    }
}
