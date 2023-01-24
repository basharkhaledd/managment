package com.ass.mangment.dto;

import com.ass.mangment.model.EmployeeEducation;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeEducationDto {

    private String certificateName;
    private String universityName;
    private String year;

    public static EmployeeEducation fromEmpEducationDto(EmployeeEducationDto employeeEducationDto){
        EmployeeEducation employeeEducation = new EmployeeEducation();
        employeeEducation.setCreationDate(LocalDate.now());
        employeeEducation.setUniversityName(employeeEducationDto.getUniversityName());
        employeeEducation.setYear(employeeEducationDto.getYear());
        employeeEducation.setCertificateName(employeeEducationDto.getCertificateName());
        return employeeEducation;
    }
}
