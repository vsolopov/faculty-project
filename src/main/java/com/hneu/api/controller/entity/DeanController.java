package com.hneu.api.controller.entity;

import com.hneu.api.model.Dean;
import com.hneu.api.service.DeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dean")
public class DeanController {
    private DeanService service;

    @PostMapping("/save")
    public ResponseEntity<Dean> save(@RequestBody Dean dean) {
        Dean resultDean = service.save(dean);
        return new ResponseEntity<>(resultDean, HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity deleteById(@RequestParam Long id) {
        boolean result = service.deleteById(id);
        if (result) return new ResponseEntity<>(HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Dean>> getAll() {
        List<Dean> all = service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Dean> getById(@PathVariable Long id) {
        Dean dean = service.getById(id);
        return new ResponseEntity<>(dean, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<Dean> getByFacultyName(@RequestParam String facultyName) {
        Dean dean = service.getByFacultyName(facultyName);
        return new ResponseEntity<>(dean, HttpStatus.OK);
    }

    @Autowired
    public void setService(DeanService service) {
        this.service = service;
    }
}

