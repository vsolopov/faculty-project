package com.hneu.api.controller.entity;

import com.hneu.api.model.Faculty;
import com.hneu.api.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(FacultyController.API)
public class FacultyController {

    public static final String API = "/api/v1/faculties";

    private final FacultyService service;


    @PostMapping
    public ResponseEntity<Faculty> save(@RequestBody Faculty faculty) {
        faculty = service.save(faculty);
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public void deleteById(@RequestParam Long id) {
        service.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<Faculty>> getAll() {
        List<Faculty> all = service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getById(@PathVariable Long id) {
        Faculty faculty = service.getById(id);
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    @GetMapping(params = "name")
    public ResponseEntity<Faculty> getByName(@RequestParam String name) {
        Faculty faculty = service.getByName(name);

        if (faculty == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(faculty, HttpStatus.OK);
        }
    }

    @GetMapping(params = "studentId")
    public ResponseEntity<Faculty> getStudentId(@RequestParam Long studentId) {
        Faculty faculty = service.getByStudentId(studentId);

        if (faculty == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(faculty, HttpStatus.OK);
        }
    }

    @GetMapping(params = "numberOfTelephone")
    public ResponseEntity<Faculty> getByNumberOfTelephone(@RequestParam String numberOfTelephone) {
        Faculty faculty = service.getByNumberOfTelephone(numberOfTelephone);

        if (faculty == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(faculty, HttpStatus.OK);
        }
    }

    @GetMapping(params = "email")
    public ResponseEntity<Faculty> getByEmail(@RequestParam String email) {
        Faculty faculty = service.getByEmail(email);

        if (faculty == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(faculty, HttpStatus.OK);
        }
    }

}
