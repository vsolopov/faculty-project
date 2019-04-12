package com.hneu.api.controller.entity;

import com.hneu.api.model.Dean;
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
        Faculty resultFaculty = service.save(faculty);
        return new ResponseEntity<>(resultFaculty, HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity deleteById(@RequestParam Long id) {
        boolean result = service.deleteById(id);
        if (result) return new ResponseEntity<>(HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
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

    @GetMapping("/get")
    public ResponseEntity<Faculty> get(@RequestParam(required = false) String name,
                                       @RequestParam(required = false) String email) {
        Faculty faculty;
        if (name == null && email == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else if (name != null) faculty = service.getByName(name);
        else faculty = service.getByEmail(email);
        if (faculty == null) return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    @PostMapping("/getbydean")
    public ResponseEntity<Faculty> getByDean(@RequestBody Dean dean) {
        Faculty resultDean = service.getByDean(dean);
        if (resultDean == null) return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        return new ResponseEntity<>(resultDean, HttpStatus.OK);
    }

    @Autowired
    public void setService(FacultyService service) {
        this.service = service;
    }
}
