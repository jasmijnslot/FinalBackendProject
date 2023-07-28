package com.example.finalbackendproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Getter
@Setter
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

    @OneToMany(mappedBy = "dier")
    @JsonIgnore
    private List<Afspraak> afspraak;

    @ManyToOne
    @JsonIgnore
    private Klant klant;

    @OneToOne
    @JsonIgnore
    private Paspoort paspoort;

    @ManyToMany
    @JsonIgnore
    private List<Medicatie> medicatie;

}

