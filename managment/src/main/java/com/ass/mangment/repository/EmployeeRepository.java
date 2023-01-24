package com.ass.mangment.repository;

import com.ass.mangment.model.Company;
import com.ass.mangment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "select * from employee ORDER BY salary desc LIMIT 3",nativeQuery = true)
    List<Employee> topSalary();
     //"select * from employee WHERE salary > 200"
    //projection

    List<Employee> findByName(String name);

}
