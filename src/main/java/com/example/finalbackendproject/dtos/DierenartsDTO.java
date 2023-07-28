package com.example.finalbackendproject.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

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

}

