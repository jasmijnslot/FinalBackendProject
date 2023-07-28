package com.example.finalbackendproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "klant")
    private List<Dier> dieren;




}

