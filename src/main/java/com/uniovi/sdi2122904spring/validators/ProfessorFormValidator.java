package com.uniovi.sdi2122904spring.validators;

import com.uniovi.sdi2122904spring.entities.Mark;
import com.uniovi.sdi2122904spring.entities.Professor;
import com.uniovi.sdi2122904spring.entities.User;
import com.uniovi.sdi2122904spring.services.ProfessorService;
import com.uniovi.sdi2122904spring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProfessorFormValidator implements Validator {
    @Autowired
    private ProfessorService usersService;
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }
    @Override
    public void validate(Object target, Errors errors) {
        Professor professor = (Professor) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Error.empty");
        if ( professor.getDni().length() !=9 ) {
            errors.rejectValue("description", "Error.mark.description");}

        char ultima=professor.getDni().charAt(8);
        if (!Character.isLetter(ultima)) {
            errors.rejectValue("description", "Error.mark.description");}
    }
}
