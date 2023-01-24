package com.ass.mangment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ass.mangment.base.BaseEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employeeEducation")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEducation extends BaseEntity<Long> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "creationDate")
    private LocalDate creationDate;
    private String CertificateName;
    private String universityName;
    private String year;

    @ManyToOne()
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;


}
