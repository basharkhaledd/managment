package com.ass.mangment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ass.mangment.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "employee")
@Setter
@Getter
@NoArgsConstructor
public class Employee extends BaseEntity<Long> {
    private static final long serialVersionUID = 5L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", nullable = false)
//    private Long employeeId;
    private String name;
    private String phone;
    private double salary;

    @ManyToOne()
    @JoinColumn(name = "company_id")
    @JsonBackReference
    private Company company;
    @OneToMany(mappedBy = "employee",
            cascade = {CascadeType.DETACH,
                    CascadeType.REFRESH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST})
    @JsonManagedReference
    private Set<EmployeeEducation> certificates;

    public Employee(String name, String email, double salary, Company company, Set<EmployeeEducation> certificates) {
        this.name = name;
        this.phone = email;
        this.salary = salary;
        this.company = company;
        this.certificates = certificates;
    }
}
