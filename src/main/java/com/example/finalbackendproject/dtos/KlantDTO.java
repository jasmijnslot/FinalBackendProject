package com.example.finalbackendproject.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

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

}

