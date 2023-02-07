package com.mycompany.myapp.service;

import com.mycompany.myapp.Constants;
import com.mycompany.myapp.Grade;
import com.mycompany.myapp.repository.GradeRepository;

import java.util.List;

public class GradeService {


    GradeRepository gradeRepository = new GradeRepository();

    public Grade getGrade(int index) {
        return gradeRepository.getGrade(index);
    }

    public void addGrade(Grade grade){
        gradeRepository.addGrade(grade);
    }

    public void updateGrade(Grade grade, int index){
        gradeRepository.updateGrade(grade, index);
    }

    public List<Grade> getGrades(){
        return gradeRepository.getGrades();
    }

    public Integer getGradeIndex(String id)
    {
        for (int i = 0; i < getGrades().size(); i++) 
        {
            if (getGrades().get(i).getId().equals(id)) 
            {
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }

    public Grade getGradeById(String id)
    {
        int index = getGradeIndex(id);

        // check if the index is found
        return index == Constants.NOT_FOUND ? new Grade() : getGrade(index);
    }

    public void submitGrade(Grade grade)
    {
        int index = getGradeIndex(grade.getId());
        
        if (index == Constants.NOT_FOUND) 
        {
            addGrade(grade);
        } 
        else 
        {
            updateGrade(grade, index);
        }
    }
    
}