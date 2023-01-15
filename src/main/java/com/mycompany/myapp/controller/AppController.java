package com.mycompany.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.Constants;
import com.mycompany.myapp.Grade;
import com.mycompany.myapp.repository.GradeRepository;

@Controller
public class AppController {
    
    GradeRepository gradeRepository = new GradeRepository();
    

    @GetMapping("/grades")
    public String getGrades(Model model){

       model.addAttribute("grades", gradeRepository.getGrades());


        return "grades"; // the template name
    }

    @GetMapping("/")
    public String submitForm(Model model, @RequestParam(required = false) String id)
    {
        int index = getGradeIndex(id);

       model.addAttribute("grade", 
                        index == Constants.NOT_FOUND ? new Grade() : gradeRepository.getGrade(index));

        return "form"; // the template name
    }

    public Integer getGradeIndex(String id)
    {
        for (int i = 0; i < gradeRepository.getGrades().size(); i++) 
        {
            if (gradeRepository.getGrades().get(i).getId().equals(id)) 
            {
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }

    @PostMapping("/submit")
    public String submitGrade(@Valid Grade grade, BindingResult result)
    {
        // check input
        if (result.hasErrors()) 
        {
            return "form";
        }

        int index = getGradeIndex(grade.getId());

        if (index == Constants.NOT_FOUND) 
        {
            gradeRepository.addGrade(grade);
        } 
        else 
        {
            gradeRepository.updateGrade(grade, index);
        }
        return "redirect:/grades";
    }
}
