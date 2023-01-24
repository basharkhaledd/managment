package com.ass.mangment.controller;

import com.ass.mangment.model.EmployeeEducation;
import com.ass.mangment.service.EmployeeEducationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/certificate")
@Log4j2
public class EmployeeEducationController {

    @Autowired
    private EmployeeEducationService employeeEducationService;

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeEducation>> getCertificate() {
        List<EmployeeEducation> employeeEducations = employeeEducationService.findAll();
        log.info("Inside Methode getEmployees to display all employees");
        return new ResponseEntity<>(employeeEducations, HttpStatus.OK);
    }
}
