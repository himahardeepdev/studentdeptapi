package com.hardeep.studentdeptapis.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hardeep.studentdeptapis.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    
}