package com.example.finalbackendproject.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Medicatie")
public class Medicatie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "naam")
    private String naam;

    @Column(name = "dosering")
    private String dosering;

    @Column(name = "opmerking")
    private String opmerking;
}

