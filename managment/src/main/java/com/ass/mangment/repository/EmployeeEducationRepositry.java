package com.ass.mangment.repository;


import com.ass.mangment.model.EmployeeEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeEducationRepositry extends JpaRepository<EmployeeEducation,Long> {




}
