package com.hneu.api.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter @Setter @Builder
@ToString @NoArgsConstructor @AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotNull
    private String name;
    @Column
    @NotNull
    private String surname;
    @Column
    @NotNull
    private String middleName;
    @Column(unique = true)
    private String numOfTelephone;
    @ManyToOne
    @JoinColumn
    private Faculty faculty;
    @Column
    private String address;
    @Column
    private String momNumberOfTelephone;
    @Temporal(TemporalType.DATE)
    @Column
    private Date studyFrom;
    @Column
    private Boolean isGraduated;
}
