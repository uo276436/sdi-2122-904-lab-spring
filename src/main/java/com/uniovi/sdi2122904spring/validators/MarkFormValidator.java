package com.uniovi.sdi2122904spring.validators;

import com.uniovi.sdi2122904spring.entities.Mark;
import com.uniovi.sdi2122904spring.entities.User;
import com.uniovi.sdi2122904spring.services.MarksService;
import com.uniovi.sdi2122904spring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MarkFormValidator implements Validator {
    @Autowired
    private MarksService usersService;
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }
    @Override
    public void validate(Object target, Errors errors) {
        Mark mark = (Mark) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Error.empty");
        if ( mark.getDescription().length() <20 ) {
            errors.rejectValue("description", "Error.mark.description");}

        if (mark.getScore() < 0 || mark.getScore() >10 ) {
            errors.rejectValue("score", "Error.mark.score");}
    }
}
