package com.hneu.api.controller.entity;

import com.hneu.api.model.Student;
import com.hneu.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService service;

    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        Student resultStudent = service.save(student);
        return new ResponseEntity<>(resultStudent, HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity deleteById(@RequestParam Long id) {
        boolean result = service.deleteById(id);
        if (result) return new ResponseEntity<>(HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> all = service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        Student student = service.getById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<Student> getByNumOfTelephone(@RequestParam(required = false) String numOfTelephone) {
        Student student = service.getByNumOfTelephone(numOfTelephone);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }
}
