package com.example.finalbackendproject.dtos;

import com.example.finalbackendproject.models.Afspraak;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

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

    @NotBlank
    private Afspraak afspraak;



}

