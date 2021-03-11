package com.hneu.api.service;

import com.hneu.api.database.dao.StudentDAO;
import com.hneu.api.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentDAO studentDAO;


    public Student save(Student student) {
        return studentDAO.save(student);
    }

    public void deleteById(Long id) {
        studentDAO.deleteById(id);
    }

    public List<Student> getAll() {
        return studentDAO.findAll();
    }

    public Student getById(Long id) {
        return studentDAO.getOne(id);
    }

    public Student getByNumOfTelephone(String numOfTelephone) {
        return studentDAO.findByNumOfTelephone(numOfTelephone);
    }

    public List<Student> getByFacultyId(Long id) {
        return studentDAO.findByFacultyId(id);
    }

}
