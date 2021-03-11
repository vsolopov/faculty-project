package com.hneu.api.database;

import com.hneu.api.database.dao.FacultyDAO;
import com.hneu.api.database.dao.StudentDAO;
import com.hneu.api.model.Faculty;
import com.hneu.api.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final StudentDAO studentDAO;
    private final FacultyDAO facultyDAO;

    @Override
    public void run(ApplicationArguments args) {
        generateAndPersistData();
    }

    private void generateAndPersistData() {
        Faculty ei = Faculty.builder()
                .name("ei")
                .email("dekei@hneu.edu.ua")
                .numberOfTelephone("380577021831").build();

        Faculty ep = Faculty.builder().name("ep")
                .email("dekep@hneu.edu.ua")
                .numberOfTelephone("380577020547").build();

        Faculty meo = Faculty.builder()
                .name("meo")
                .email(" dekmeo@ksue.edu.ua")
                .numberOfTelephone("380577021832").build();

        facultyDAO.saveAll(Arrays.asList(ei, ep, meo));


        List<Student> students = Arrays.asList(
                Student.builder()
                        .surname("Solopov")
                        .name("Vladyslav")
                        .middleName("Igorevich")

                        .address("Kharkiv").
                        isGraduated(false).
                        numOfTelephone("somenumber1").
                        faculty(ei).build(),


                Student.builder()
                        .surname("Miroshnichenko").
                        name("Dmitrii").
                        middleName("Anreevich")

                        .address("Kharkiv").
                        isGraduated(false).
                        numOfTelephone("somenumber2").
                        faculty(ei).build(),


                Student.builder().
                        surname("Borbat").
                        name("Viralii").
                        middleName("Yuriyovich")

                        .address("s.Zachepilovka").
                        isGraduated(true).
                        numOfTelephone("somenumber3").
                        faculty(ep).build()
        );

        studentDAO.saveAll(students);
    }
}
