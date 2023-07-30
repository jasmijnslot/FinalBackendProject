package com.example.finalbackendproject.dtos;

import com.example.finalbackendproject.models.Dier;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import java.util.List;

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

    private List<Dier> dieren;


}

