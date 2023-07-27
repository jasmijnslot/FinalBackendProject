package com.example.finalbackendproject.models;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id")
    private Dier dier;


}
