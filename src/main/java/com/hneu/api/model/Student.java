package com.hneu.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String middleName;
    @Column(unique = true, nullable = false)
    private String numOfTelephone;
    private String address;
    private String momNumberOfTelephone;
    @Temporal(TemporalType.DATE)
    private Date studyFrom;
    private Boolean isGraduated;

    @ManyToOne
    private Faculty faculty;

}
