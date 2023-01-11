package com.mycompany.myapp;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class Grade {

    @NotBlank(message = "Name is Required")
    private String name;
    @NotBlank(message = "Subject is Required")
    private String subject;
    private String score;
    private String id;

    public Grade() 
    {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", subject='" + getSubject() + "'" +
            ", score='" + getScore() + "'" +
            "}";
    }


}
