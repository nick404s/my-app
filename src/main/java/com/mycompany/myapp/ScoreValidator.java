package com.mycompany.myapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ScoreValidator implements ConstraintValidator <Score, String> {


    protected static final Set<String> scores = new HashSet<>(Arrays.asList(
        "A", "B", "C", "D", "F"
    ));

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return scores.contains(value);
    } 
}
