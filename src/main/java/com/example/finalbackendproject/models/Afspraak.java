package com.example.finalbackendproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Afspraak")
public class Afspraak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "datum")
    private Date datum;

    @Column(name = "reden")
    private String reden;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "dier_id")
    private Dier dier;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "klant_id")
    private Klant klant;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "dierenarts_id")
    private Dierenarts dierenarts;

}
