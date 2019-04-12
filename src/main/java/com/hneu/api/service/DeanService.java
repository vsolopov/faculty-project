package com.hneu.api.service;

import com.hneu.api.dao.DeanDAO;
import com.hneu.api.exception.EntityExceptionExt.DeanException;
import com.hneu.api.exception.EntityExceptionExt.StudentException;
import com.hneu.api.model.Dean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeanService {
    private DeanDAO deanDAO;

    public Dean save(Dean dean) {
        Dean resultDean = deanDAO.save(dean);
        if (resultDean == null) throw new DeanException("dean hasn't been added");
        return resultDean;
    }

    public boolean deleteById(Long id) {
        deanDAO.deleteById(id);
        return !deanDAO.existsById(id);
    }

    public List<Dean> getAll() {
        List<Dean> all = deanDAO.findAll();
        if (all == null || all.isEmpty()) throw new DeanException("no one dean");
        return all;
    }

    public Dean getByFacultyName(String facultyName) {
        Dean dean = deanDAO.findByFacultyName(facultyName);
        if (dean == null) throw new DeanException("Dean by faculty name doesn't exist");
        return dean;
    }

    public Dean getById(Long id) {
        Dean dean = deanDAO.getOne(id);
        if (dean == null) throw new StudentException("no one dean by id");
        return dean;
    }

    @Autowired
    public void setDeanDAO(DeanDAO deanDAO) {
        this.deanDAO = deanDAO;
    }
}
