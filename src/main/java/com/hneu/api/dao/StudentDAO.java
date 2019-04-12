package com.hneu.api.dao;

import com.hneu.api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student, Long> {
    Student findByNumOfTelephone(String numOfTelephone);
}
