package com.example.finalbackendproject.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Klant")
public class Klant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "achterNaam")
    private String achterNaam;

    @Column(name = "telefoonNr")
    private String telefoonNr;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "email")
    private String email;


}

