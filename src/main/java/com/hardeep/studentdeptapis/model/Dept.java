package com.hardeep.studentdeptapis.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    
    @Id
    @Column(name = "dept_id")
    private String deptCode;
    @Column(name = "dept_name")
    private String dname;

    @JsonBackReference
    @OneToMany(mappedBy = "dept", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Student> students;

}
