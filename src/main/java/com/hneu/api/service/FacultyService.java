package com.hneu.api.service;

import com.hneu.api.database.dao.FacultyDAO;
import com.hneu.api.database.dao.StudentDAO;
import com.hneu.api.exception.EntityExceptionExt.FacultyException;
import com.hneu.api.model.Faculty;
import com.hneu.api.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyService {

    private final FacultyDAO facultyDAO;
    private final StudentDAO studentDAO;


    public Faculty save(Faculty faculty) {

        if (faculty.getId() == null) {
            if (facultyDAO.findByEmail(faculty.getEmail()) != null) {
                throw new FacultyException("faculty email already exist");
            } else if (facultyDAO.findByName(faculty.getName()) != null) {
                throw new FacultyException("faculty name already exist");
            } else if (facultyDAO.findByNumberOfTelephone(faculty.getNumberOfTelephone()) != null) {
                throw new FacultyException("faculty number of telephone already exist");
            }
        }
        return facultyDAO.save(faculty);
    }

    public void deleteById(Long id) {
        facultyDAO.deleteById(id);
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
        return studentDAO.findById(studentId).map(Student::getFaculty).orElseGet(null);
    }

}
