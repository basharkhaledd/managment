package com.ass.mangment.service;

import com.ass.mangment.exceptions.NotFoundCompanyException;
import com.ass.mangment.repository.CompanyRepository;
import com.ass.mangment.repository.EmployeeRepository;
import com.ass.mangment.dto.CompanyDto;
import com.ass.mangment.model.Company;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@Log
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeService;



    public List<Company> getAllDepartments() {
        return this.companyRepository.findAll();
    }

    public Company addCompany(CompanyDto departmentDto) {
        Company department = CompanyDto.fromDepartmentDto(departmentDto);
        department.setCreationDate(LocalDate.now());
        log.info("Inside Methode getAllDepartments to display All departments");
        return this.companyRepository.save(department);
    }


    public Company updateCompany(CompanyDto departmentDto) {

        Company department = companyRepository.findById(departmentDto.getId()).orElseThrow(
                () -> new NotFoundCompanyException("you cant update department with  id " + departmentDto.getId()
                        + " because there is no department with such id" + departmentDto.getId()));
        department.setLocation(departmentDto.getLocation());
        department.setName(departmentDto.getName());
        log.info("the Department has been update Successfully");
        return this.companyRepository.save(department);
    }


    public Company findCompanyById(Long departmentId) {
        log.info("Inside findDepartmentById.....");
        return companyRepository.findById(departmentId).orElseThrow(
                () -> new NotFoundCompanyException("Department not found for this id :: " + departmentId));
    }

    public Map<String, Boolean> deleteCompany(Long departmentId) throws NotFoundCompanyException {
        Company department = companyRepository.findById(departmentId).orElseThrow(
                () -> new NotFoundCompanyException("Department not found for this id :: " + departmentId));
        department.getEmployees().forEach((emp) -> {
            emp.setCompany(null);
            this.employeeService.save(emp);
        });
        companyRepository.delete(department);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    private void CompantNotExist(Long id, String message) {
        CompantNotExist(id, "you cant delete employee with id " + id + " because there is no employee with such id");
        companyRepository.findById(id).orElseThrow(() -> new NotFoundCompanyException(message));
    }





}
