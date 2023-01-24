
package com.ass.mangment.dto;

import com.ass.mangment.model.Employee;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
    public String name;
    public String phone;
    public double salary;
    public Long companyId;
    public String companyName;

    public static EmployeeDto toEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setPhone(employee.getPhone());
        employeeDto.setName(employee.getName());
        employeeDto.setSalary(employee.getSalary());
        return employeeDto;
    }

    public static Employee fromEmployeeDto(EmployeeDto employeeDto){
        Employee employee = new Employee();
       // employee.setEmployeeId(employeeDto.getId());
        employee.setPhone(employeeDto.getPhone());
        employee.setName(employeeDto.getName());
        employee.setSalary(employeeDto.getSalary());
        return employee;
    }

}

