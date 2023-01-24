package com.ass.mangment.controller;


import com.ass.mangment.dto.EmployeeDto;
import com.ass.mangment.dto.EmployeeEducationDto;
import com.ass.mangment.model.Employee;
import com.ass.mangment.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Log4j2
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.findAll();
        log.info("Inside Methode getEmployees to display all employees");
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = new Employee();
        Employee newEmployee = employeeService.addEmployee(employeeDto);
        EmployeeDto employeeDto1 = EmployeeDto.toEmployeeDto(newEmployee);
        return new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }


    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.updateEmployee(employeeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/requestC/{employeeId}")
    public ResponseEntity<?> requesCertificate(@PathVariable("employeeId") Long employeeId, @RequestBody EmployeeEducationDto employeeEducationDto) {
        employeeService.addCertificate(employeeId, employeeEducationDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/requestC/{employeeId}/{companyId}")
    public ResponseEntity<?> requestEmployee(@PathVariable("employeeId") Long employeeId,
                                             @PathVariable("companyId") Long companyId
                                           ) {
        employeeService.addCompany(employeeId, companyId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/top")
    public ResponseEntity<List<Employee>> getTopSalary() {
        List<Employee> employees = employeeService.getTopthreeSalary();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Employee>> getByName(@PathVariable("name") String name) {
        List<Employee> employees = employeeService.getEmployeeByName(name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


}
