package com.example.finalbackendproject.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Dier")
public class Dier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "naam")
    private String naam;

    @Column(name = "geboorteDatum")
    private Date geboorteDatum;

    @Column(name = "soort")
    private String soort;

    @OneToOne(mappedBy = "dier")
    private Afspraak afspraak;

}

