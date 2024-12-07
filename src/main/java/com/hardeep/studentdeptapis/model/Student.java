package com.hardeep.studentdeptapis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    
    @Id
    private int id;
    private String name;
    private int marks;
    
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Dept dept;



    
}