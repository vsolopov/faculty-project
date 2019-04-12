package com.hneu.api.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class Dean {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "dean")
    private Faculty faculty;
    @Column @NotNull
    private String name;
    @Column @NotNull
    private String surname;
    @Column @NotNull
    private String middleName;
    @Column
    private String numOfTelephone;
}
