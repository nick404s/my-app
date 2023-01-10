package com.mycompany.myapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
    
    List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/grades")
    public String getGrades(Model model){

       model.addAttribute("grades", studentGrades);


        return "grades"; // the template name
    }

    @GetMapping("/")
    public String submitForm(Model model, @RequestParam(required = false) String id)
    {
        int index = getGradeIndex(id);

       model.addAttribute("grade", 
                        index == Constants.NOT_FOUND ? new Grade() : studentGrades.get(index));

        return "form"; // the template name
    }

    public Integer getGradeIndex(String id)
    {
        for (int i = 0; i < studentGrades.size(); i++) 
        {
            if (studentGrades.get(i).getId().equals(id)) 
            {
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }

    @PostMapping("/submit")
    public String submitGrade(Grade grade)
    {
        int index = getGradeIndex(grade.getId());
        if (index == Constants.NOT_FOUND) 
        {
            studentGrades.add(grade);
        } 
        else 
        {
            studentGrades.set(index, grade);
        }
        return "redirect:/grades";
    }
}
