package com.hneu.api.dao;

import com.hneu.api.model.Dean;
import com.hneu.api.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyDAO extends JpaRepository<Faculty, Long> {
    Faculty findByName(String name);
    Faculty findByEmail(String email);
    Faculty findByDean(Dean dean);
}
