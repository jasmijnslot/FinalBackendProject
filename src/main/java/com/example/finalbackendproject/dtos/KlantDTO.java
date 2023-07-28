package com.example.finalbackendproject.dtos;

import com.example.finalbackendproject.models.Afspraak;
import com.example.finalbackendproject.models.Dier;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class KlantDTO {

    private Long id;

    @NotBlank
    private String achterNaam;

    @NotBlank
    private String telefoonNr;

    @NotBlank
    private String postcode;

    @NotBlank
    private String email;

    private List<Dier> dieren;

    private List<Afspraak> afspraken;

}

