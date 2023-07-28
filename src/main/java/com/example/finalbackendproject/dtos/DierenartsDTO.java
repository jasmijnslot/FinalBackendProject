package com.example.finalbackendproject.dtos;

import com.example.finalbackendproject.models.Afspraak;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import java.util.List;

@Getter
@Setter
public class DierenartsDTO {

    private Long id;

    @NotBlank
    private String achterNaam;

    @NotBlank
    private int telefoonNr;

    @NotBlank
    private String specialisatie;

    private List<Afspraak> afspraak;
}

