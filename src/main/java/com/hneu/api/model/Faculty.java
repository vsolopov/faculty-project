package com.hneu.api.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class Faculty {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "faculty")
    private List<Student> students;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "faculty_dean",
            joinColumns = @JoinColumn(name="faculty_id"),
            inverseJoinColumns = @JoinColumn(name="dean_id"))
    private Dean dean;
    @Column(unique=true)
    private String name;
    @Column(unique=true)
    private String email;
    @Column
    private String numberOfTelephone;
}
