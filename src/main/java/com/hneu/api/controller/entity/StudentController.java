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
    public void deleteById(@RequestParam Long id) {
        service.deleteById(id);
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

    @GetMapping("/getByNumOfTelephone/{number}")
    public ResponseEntity getByNumOfTelephone(@PathVariable String number) {
        Student student = service.getByNumOfTelephone(number);
        if (student == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/getByFacultyId/{facultyId}")
    public ResponseEntity getByFacultyId(@PathVariable Long facultyId) {
        List<Student> faculty = service.getByFacultyId(facultyId);
        if (faculty == null) return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }
}
