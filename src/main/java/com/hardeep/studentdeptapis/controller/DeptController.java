package com.hardeep.studentdeptapis.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardeep.studentdeptapis.model.Dept;
import com.hardeep.studentdeptapis.model.Student;
import com.hardeep.studentdeptapis.service.dept.DeptService;

@RestController
@RequestMapping("/api/dept")
@CrossOrigin(origins = "http://localhost:3000")
public class DeptController {

    private DeptService deptService;

    public DeptController(DeptService deptService){
        this.deptService = deptService;
    }

    @PostMapping
    public ResponseEntity<Dept> saveDept(@RequestBody Dept dept){
        try {
            return new ResponseEntity<>(deptService.saveDept(dept) , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<List<Dept>> getAllDept(){
        try {
            return new ResponseEntity<>(deptService.getAllDept() , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{deptCode}")
    public ResponseEntity<Dept> getDeptById(@PathVariable String deptCode){
        try {
            return new ResponseEntity<>(deptService.getDeptById(deptCode), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/student/{deptCode}")
    public ResponseEntity<List<Student>> getStudentByDeptCode(@PathVariable String deptCode){
            try {
                return new ResponseEntity<>(deptService.getStudentsByDeptCode(deptCode) , HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

    @PutMapping("/{deptCode}")
    public ResponseEntity<Void> updateDeptData(@PathVariable String deptCode , @RequestBody Dept dept){
        try {
            deptService.updateDeptById(deptCode, dept);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{deptCode}")
    public ResponseEntity<Void> deleteDeptById(@PathVariable String deptCode){
        try {
            deptService.deleteDeptByCode(deptCode);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
