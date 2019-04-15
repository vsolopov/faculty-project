package com.hneu.api.database.dao;

import com.hneu.api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDAO extends JpaRepository<Student, Long> {
    Student findByNumOfTelephone(String numOfTelephone);

    List<Student> findByFacultyId(Long id);
}
