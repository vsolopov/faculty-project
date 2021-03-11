package com.hneu.api.controller.entity;

import com.hneu.api.model.Student;
import com.hneu.api.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(StudentController.API)
public class StudentController {

    public static final String API = "/api/v1/students";

    private final StudentService service;


    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        Student resultStudent = service.save(student);
        return new ResponseEntity<>(resultStudent, HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public void deleteById(@RequestParam Long id) {
        service.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        List<Student> all = service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        Student student = service.getById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping(params = "number")
    public ResponseEntity<Student> getByNumOfTelephone(@RequestParam String number) {
        Student student = service.getByNumOfTelephone(number);
        if (student == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping(params = "facultyId")
    public ResponseEntity<List<Student>> getByFacultyId(@RequestParam Long facultyId) {
        List<Student> faculty = service.getByFacultyId(facultyId);
        if (faculty == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

}
