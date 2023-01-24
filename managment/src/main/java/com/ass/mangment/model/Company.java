package com.ass.mangment.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ass.mangment.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "company")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company extends BaseEntity<Long> {

    private String name;
    private String location;
    @OneToMany(mappedBy = "company", cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.PERSIST })
    @JsonManagedReference
    private List<Employee> employees;

}
