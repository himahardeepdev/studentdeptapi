package com.hardeep.studentdeptapis.repositorty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hardeep.studentdeptapis.model.Dept;
import com.hardeep.studentdeptapis.model.Student;

public interface DeptRepository extends JpaRepository<Dept,String> {
    @Query("SELECT s FROM Student s WHERE s.dept.deptCode = :deptCode")
    List<Student> findStudentsByDeptCode(@Param("deptCode") String deptCode);
    
}
