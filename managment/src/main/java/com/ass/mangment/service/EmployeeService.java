package com.ass.mangment.service;

import com.ass.mangment.dto.EmployeeEducationDto;
import com.ass.mangment.exceptions.EmployeeNotFoundException;
import com.ass.mangment.dto.EmployeeDto;
import com.ass.mangment.model.Company;
import com.ass.mangment.model.Employee;
import com.ass.mangment.model.EmployeeEducation;
import com.ass.mangment.repository.CompanyRepository;
import com.ass.mangment.repository.EmployeeEducationRepositry;
import com.ass.mangment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeEducationRepositry employeeEducationRepositry;
    @Autowired
    CompanyRepository companyRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeDto.fromEmployeeDto(employeeDto);
//        employee.setCreationDate(LocalDate.now());
//        Company company = departmentRepository.findById(employeeDto.getCompanyId())
//                .orElseThrow(() -> new NotFoundCompanyException("Employee by id "
//                        + employeeDto.getCompanyId() + " was not found"));
//        employee.setCompany(company);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeDto.fromEmployeeDto(employeeDto);
        return employeeRepository.save(employee);
    }


    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                        new EmployeeNotFoundException("Employee by id " + id + " was not found"));
    }


    @Transactional
    public void addCertificate(Long employeeId, EmployeeEducationDto employeeEducationDto) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()
                -> new EmployeeNotFoundException("there is no such emp"));

        Set<EmployeeEducation> employeeEducations = new HashSet<>();

        employeeEducations.addAll(employee.getCertificates());

        EmployeeEducation employeeEducation = EmployeeEducationDto.fromEmpEducationDto(employeeEducationDto);
        employeeEducation.setEmployee(employee);
        employeeEducations.add(employeeEducation);
        employee.setCertificates(employeeEducations);

        employeeRepository.save(employee);


    }





    @Transactional
    public void addCompany(Long employeeId, Long companyId ) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()
                -> new EmployeeNotFoundException("there is no such emp"));


        Company company = companyRepository.findById(companyId)
                .orElseThrow(()
                        -> new EmployeeNotFoundException("there is no such emp"));
                employee.setCompany(company);
        employeeRepository.save(employee);

    }

    public List<Employee> getTopthreeSalary (){
      return employeeRepository.topSalary();
    }

    public List<Employee> getEmployeeByName (String name){
        return employeeRepository.findByName(name);
    }




}
