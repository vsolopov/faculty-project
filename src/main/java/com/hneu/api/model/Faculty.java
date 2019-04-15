package com.hneu.api.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "faculty")
    private List<Student> students;
    @Column(unique = true)
    @NotNull
    private String name;
    @Column(unique = true)
    @NotNull
    private String email;
    @Column
    private String numberOfTelephone;
}
