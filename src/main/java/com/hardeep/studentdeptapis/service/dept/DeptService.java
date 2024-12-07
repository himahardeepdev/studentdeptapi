package com.hardeep.studentdeptapis.service.dept;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hardeep.studentdeptapis.exception.ResourceNotFound;
import com.hardeep.studentdeptapis.model.Dept;
import com.hardeep.studentdeptapis.model.Student;
import com.hardeep.studentdeptapis.repositorty.DeptRepository;

@Service
public class DeptService implements IdeptService {

    private DeptRepository deptRepository;
    
    public DeptService(DeptRepository deptRepository){
        this.deptRepository = deptRepository;
    }

    @Override
    public Dept saveDept(Dept dept) {
        Dept check = deptRepository.findById(dept.getDeptCode()).get();
        if (check == null) {
            return deptRepository.save(dept);
        }
        throw new ResourceNotFound("Dept already exist");
    }

    @Override
    public List<Dept> getAllDept() {
        return deptRepository.findAll();
    }

    @Override
    public Dept getDeptById(String deptCode) {
        return deptRepository.findById(deptCode).orElseThrow(()-> new ResourceNotFound("Dept is not found"+deptCode));
    }

    @Override
    public void updateDeptById(String deptCode, Dept dept) {
        deptRepository.findById(deptCode).orElseThrow(()-> new ResourceNotFound("Dept not found "+deptCode));
        dept.setDeptCode(deptCode);
        deptRepository.save(dept);
    }

    @Override
    public List<Student> getStudentsByDeptCode(String deptCode) {
        try {
            deptRepository.findById(deptCode).orElseThrow(()-> new ResourceNotFound("Dept not found "+deptCode));
            return deptRepository.findStudentsByDeptCode(deptCode);
        } catch (Exception e) {
            throw new ResourceNotFound("Data is not fetching from student base on dept  ");
        }
        
    }

    @Override
    public void deleteDeptByCode(String deptCode) {
            deptRepository.findById(deptCode).orElseThrow(()-> new ResourceNotFound("Dept is not found "+deptCode));
            deptRepository.deleteById(deptCode);
        
    }
    
}
