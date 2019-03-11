package com.example.appdemo.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.appdemo.Constants.AppDemoConstants;
import com.example.appdemo.User.User;
import com.example.appdemo.utilities.AppdemoUtils;

public class EditUserProfileValidator implements Validator {

    @Override
    public boolean supports(final Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(final Object object, final Errors errors) {
        User user = (User) object;

        ValidationUtils.rejectIfEmpty(errors, "name", "error.userName.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "error.userLastName.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");

        if (!user.getEmail().equals(null)){
            if (!AppdemoUtils.checkEmailOrPassword(AppDemoConstants.EMAIL_PATTERN, user.getEmail())) {
                errors.rejectValue("email", "error.userEmailIsNotMatch");
            }
        }

    }
}


