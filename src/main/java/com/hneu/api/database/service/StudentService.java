package com.hneu.api.database.service;

import com.hneu.api.database.dao.FacultyDAO;
import com.hneu.api.database.dao.StudentDAO;
import com.hneu.api.exception.EntityExceptionExt.FacultyException;
import com.hneu.api.exception.EntityExceptionExt.StudentException;
import com.hneu.api.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentDAO studentDAO;
    private FacultyDAO facultyDAO;

    public Student save(Student student) {
        Student resultStudent = studentDAO.save(student);
        if (resultStudent == null) throw new StudentException("student hasn't been added");
        return resultStudent;
    }

    public void deleteById(Long id) {
        studentDAO.deleteById(id);
        if (studentDAO.existsById(id)) throw new StudentException("student hasn't been deleted");
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
        if (!facultyDAO.findById(id).isPresent()) throw new FacultyException("faculty by same id not exist");
        return studentDAO.findByFacultyId(id);
    }

    @Autowired
    public void setFacultyDAO(FacultyDAO facultyDAO) {
        this.facultyDAO = facultyDAO;
    }

    @Autowired
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
}
