package com.hneu.api.database.service;

import com.hneu.api.database.dao.FacultyDAO;
import com.hneu.api.database.dao.StudentDAO;
import com.hneu.api.exception.EntityExceptionExt.FacultyException;
import com.hneu.api.exception.EntityExceptionExt.StudentException;
import com.hneu.api.model.Faculty;
import com.hneu.api.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    private FacultyDAO facultyDAO;
    private StudentDAO studentDAO;

    public Faculty save(Faculty faculty) {
        if (faculty.getId() == null) {
            if (facultyDAO.findByEmail(faculty.getEmail()) != null)
                throw new FacultyException("faculty email already exist");
            else if (facultyDAO.findByName(faculty.getName()) != null)
                throw new FacultyException("faculty name already exist");
            else if (facultyDAO.findByNumberOfTelephone(faculty.getNumberOfTelephone()) != null)
                throw new FacultyException("faculty number of telephone already exist");
        }
        faculty = facultyDAO.save(faculty);
        if (faculty == null) throw new FacultyException("faculty hasn't been added");
        return faculty;
    }

    public void deleteById(Long id) {
        facultyDAO.deleteById(id);
        if (facultyDAO.existsById(id)) throw new FacultyException("faculty hasn't been deleted");
    }

    public List<Faculty> getAll() {
        return facultyDAO.findAll();
    }

    public Faculty getById(Long id) {
        return facultyDAO.getOne(id);
    }

    public Faculty getByName(String name) {
        return facultyDAO.findByName(name);
    }

    public Faculty getByEmail(String email) {
        return facultyDAO.findByEmail(email);
    }

    public Faculty getByNumberOfTelephone(String number) {
        return facultyDAO.findByNumberOfTelephone(number);
    }


    public Faculty getByStudentId(Long studentId) {
        Student student = studentDAO.getOne(studentId);
        if (student == null) throw new StudentException("student by same id not exists");
        return student.getFaculty();
    }

    @Autowired
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Autowired
    public void setFacultyDAO(FacultyDAO facultyDAO) {
        this.facultyDAO = facultyDAO;
    }
}
