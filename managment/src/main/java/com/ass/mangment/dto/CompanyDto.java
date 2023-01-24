package com.ass.mangment.dto;

import com.ass.mangment.model.Company;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDto {
    public Long id;
    public String name;
    public String location;

    public static Company fromDepartmentDto(CompanyDto companyDto){
        Company company = new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setLocation(companyDto.getLocation());
        return company;
    }
}
