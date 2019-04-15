package com.hneu.api.database.dao;

import com.hneu.api.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyDAO extends JpaRepository<Faculty, Long> {
    Faculty findByName(String name);

    Faculty findByEmail(String email);

    Faculty findByNumberOfTelephone(String number);
}
