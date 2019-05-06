package com.herbaciarnia.validator;

import com.herbaciarnia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements
        ConstraintValidator<UsernameConstraint, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UsernameConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String username,
                           ConstraintValidatorContext cxt) {
        //return userRepository.findOne(username) == null;
        return true;
    }

}