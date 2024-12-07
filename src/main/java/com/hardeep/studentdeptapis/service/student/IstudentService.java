package com.hardeep.studentdeptapis.service.student;

import java.util.List;

import com.hardeep.studentdeptapis.model.Student;

public interface IstudentService {

    public Student saveStudent(Student student);
    public List<Student> getAllStudent();
    public Student getStudentById(int id);
    public void updateStudentById(int id , Student student);
    public void deleteStudentById(int id);
    
}