package com.mycompany.myapp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.Grade;
import com.mycompany.myapp.service.GradeService;

@Controller
public class AppController {
    
    GradeService gradeService = new GradeService();
    

    @GetMapping("/grades")
    public String getGrades(Model model){

       model.addAttribute("grades", gradeService.getGrades());


        return "grades"; // the template name
    }

    @GetMapping("/")
    public String submitForm(Model model, @RequestParam(required = false) String id)
    {
       model.addAttribute("grade", gradeService.getGradeById(id));

        return "form"; // the template name
    }


    @PostMapping("/submit")
    public String submitGrade(@Valid Grade grade, BindingResult result)
    {
        // check input
        if (result.hasErrors()) 
        {
            return "form";
        }

        gradeService.submitGrade(grade);

        return "redirect:/grades";
    }
}
