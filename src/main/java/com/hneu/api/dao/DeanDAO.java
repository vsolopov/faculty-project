package com.hneu.api.dao;

import com.hneu.api.model.Dean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeanDAO extends JpaRepository<Dean, Long> {
    Dean findByFacultyName(String name);
}
