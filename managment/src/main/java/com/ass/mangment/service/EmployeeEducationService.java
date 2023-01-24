package com.ass.mangment.service;

import com.ass.mangment.model.EmployeeEducation;
import com.ass.mangment.repository.EmployeeEducationRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeEducationService {

    @Autowired
    EmployeeEducationRepositry employeeEducationRepositry;

    public List<EmployeeEducation> findAll() {
        return employeeEducationRepositry.findAll();
    }

}
