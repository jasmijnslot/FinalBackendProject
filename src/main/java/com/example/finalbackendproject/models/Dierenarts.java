package com.example.finalbackendproject.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Dierenarts")
public class Dierenarts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "achterNaam")
    private String achterNaam;

    @Column(name = "telefoonNr")
    private int telefoonNr;

    @Column(name = "specialisatie")
    private String specialisatie;
}

