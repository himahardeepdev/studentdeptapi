package com.hardeep.studentdeptapis.service.dept;

import java.util.List;

import com.hardeep.studentdeptapis.model.Dept;
import com.hardeep.studentdeptapis.model.Student;

public interface IdeptService {

    public Dept saveDept(Dept dept);
    public List<Dept> getAllDept();
    public Dept getDeptById(String deptCode);
    public void updateDeptById(String deptCode , Dept dept);
    public List<Student> getStudentsByDeptCode(String deptCode);
    public void deleteDeptByCode(String deptCode);
}