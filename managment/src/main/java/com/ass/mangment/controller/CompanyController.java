package com.ass.mangment.controller;

import com.ass.mangment.model.Company;
import com.ass.mangment.service.CompanyService;
import com.ass.mangment.dto.CompanyDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@Log4j2
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    @GetMapping("/all")
    public ResponseEntity<List<Company>> getCompany() {
        List<Company> companies = companyService.getAllDepartments();
        log.info("Inside Methode getAllDepartments to display All departments");
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Company> addCompany(@RequestBody CompanyDto departmentDto) {
        Company newCompany = companyService.addCompany(departmentDto);
        return new ResponseEntity<>(newCompany, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getCompanyById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(companyService.findCompanyById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable("id") Long id) {
        companyService.deleteCompany(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Company> updateCompany(@RequestBody CompanyDto departmentDto) {
        companyService.updateCompany(departmentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
