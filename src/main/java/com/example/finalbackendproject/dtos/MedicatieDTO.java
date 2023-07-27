package com.example.finalbackendproject.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
public class MedicatieDTO {

    private Long id;

    @NotBlank
    private String naam;

    @NotBlank
    private String dosering;

    @NotBlank
    private String opmerking;


}

