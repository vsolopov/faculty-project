package com.hneu.api.service;

import com.hneu.api.dao.FacultyDAO;
import com.hneu.api.exception.EntityExceptionExt.FacultyException;
import com.hneu.api.exception.EntityExceptionExt.StudentException;
import com.hneu.api.model.Dean;
import com.hneu.api.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    private FacultyDAO facultyDAO;

    public Faculty save(Faculty faculty) {
        Faculty resultFaculty = facultyDAO.save(faculty);
        if (resultFaculty == null) throw new FacultyException("faculty hasn't been added");
        return resultFaculty;
    }

    public boolean deleteById(Long id) {
        facultyDAO.deleteById(id);
        return !facultyDAO.existsById(id);
    }

    public List<Faculty> getAll() {
        List<Faculty> all = facultyDAO.findAll();
        if (all == null || all.isEmpty()) throw new FacultyException("no one faculty");
        return all;
    }

    public Faculty getById(Long id) {
        Faculty faculty = facultyDAO.getOne(id);
        if (faculty == null) throw new StudentException("no one faculty by id");
        return faculty;
    }

    public Faculty getByName(String name) {
        Faculty faculty = facultyDAO.findByName(name);
        if (faculty == null) throw new StudentException("no one faculty by name");
        return faculty;
    }

    public Faculty getByEmail(String email) {
        Faculty faculty = facultyDAO.findByEmail(email);
        if (faculty == null) throw new StudentException("no one faculty by email");
        return faculty;
    }

    public Faculty getByDean(Dean dean) {
        Faculty faculty = facultyDAO.findByDean(dean);
        if (faculty == null) throw new StudentException("no one faculty by dean");
        return faculty;
    }

    @Autowired
    public void setFacultyDAO(FacultyDAO facultyDAO) {
        this.facultyDAO = facultyDAO;
    }
}
