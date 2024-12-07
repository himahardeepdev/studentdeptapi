package com.hardeep.studentdeptapis.service.student;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hardeep.studentdeptapis.exception.ResourceNotFound;
import com.hardeep.studentdeptapis.model.Student;
import com.hardeep.studentdeptapis.repositorty.StudentRepository;

@Service
public class StudentService implements IstudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow(()->new ResourceNotFound("Not student is found "+ id));
    }

    @Override
    public void updateStudentById(int id, Student student) {
        studentRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Student is not found"+id));
        student.setId(id);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Student not found "+id));
        studentRepository.deleteById(id);
    }
    
}
