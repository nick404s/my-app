package com.mycompany.myapp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ScoreValidator.class)
public @interface Score {

    // The nessesary elements for the Constraint annotation
    //default message if constraint is violated
    String message() default "Invalid Data";
    //boilerplate parameters
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
}
