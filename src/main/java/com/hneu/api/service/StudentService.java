package com.hneu.api.service;

import com.hneu.api.dao.StudentDAO;
import com.hneu.api.exception.EntityExceptionExt.StudentException;
import com.hneu.api.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentDAO studentDAO;

    public Student save(Student student) {
        Student resultStudent = studentDAO.save(student);
        if (resultStudent == null) throw new StudentException("student hasn't been added");
        return resultStudent;
    }

    public boolean deleteById(Long id) {
        studentDAO.deleteById(id);
        return !studentDAO.existsById(id);
    }

    public List<Student> getAll() {
        List<Student> all = studentDAO.findAll();
        if (all == null || all.isEmpty()) throw new StudentException("no one student");
        return all;
    }

    public Student getById(Long id) {
        Student student = studentDAO.getOne(id);
        if (student == null) throw new StudentException("no one student by id");
        return student;
    }

    public Student getByNumOfTelephone(String numOfTelephone) {
        Student student = studentDAO.findByNumOfTelephone(numOfTelephone);
        if (student == null) throw new StudentException("no one student by number of telephone");
        return student;
    }

    @Autowired
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
}
