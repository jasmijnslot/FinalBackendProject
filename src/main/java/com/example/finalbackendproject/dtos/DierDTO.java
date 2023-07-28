package com.example.finalbackendproject.dtos;

import com.example.finalbackendproject.models.Afspraak;
import com.example.finalbackendproject.models.Klant;
import com.example.finalbackendproject.models.Medicatie;
import com.example.finalbackendproject.models.Paspoort;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class DierDTO {

    private Long id;

    @NotBlank
    private String naam;

    @NotBlank
    private Date geboorteDatum;

    @NotBlank
    private String soort;

    private List<Afspraak> afspraak;

    private List<Medicatie> medicatie;

    private Klant klant;

    private Paspoort paspoort;



}

