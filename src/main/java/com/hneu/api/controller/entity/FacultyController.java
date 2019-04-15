package com.hneu.api.controller.entity;

import com.hneu.api.model.Faculty;
import com.hneu.api.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private FacultyService service;

    @PostMapping("/save")
    public ResponseEntity<Faculty> save(@RequestBody Faculty faculty) {
        faculty = service.save(faculty);
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    @GetMapping("/delete")
    public void deleteById(@RequestParam Long id) {
        service.deleteById(id);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Faculty>> getAll() {
        List<Faculty> all = service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Faculty> getById(@PathVariable Long id) {
        Faculty faculty = service.getById(id);
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

      @GetMapping("/getByName/{name}")
    public ResponseEntity getByName(@PathVariable String name){
        Faculty faculty = service.getByName(name);
        if(faculty==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
        else return new ResponseEntity<>(faculty,HttpStatus.OK);
    }
    @GetMapping("/getByStudentId/{studentId}")
    public ResponseEntity getStudentId(@PathVariable Long studentId){
        Faculty faculty = service.getByStudentId(studentId);
        if(faculty==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
        else return new ResponseEntity<>(faculty,HttpStatus.OK);
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity getByEmail(@PathVariable String email){
        Faculty faculty = service.getByEmail(email);
        if(faculty==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
        else return new ResponseEntity<>(faculty, HttpStatus.OK);
    }
    
    @Autowired
    public void setService(FacultyService service) {
        this.service = service;
    }
}
