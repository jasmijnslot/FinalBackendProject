package com.example.finalbackendproject.dtos;

import com.example.finalbackendproject.models.Dier;
import com.example.finalbackendproject.models.Dierenarts;
import com.example.finalbackendproject.models.Klant;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
public class AfspraakDTO {

    private Long id;

    @NotBlank
    private Date datum;

    @NotBlank
    private String reden;

    @NotBlank
    private Dier dier;

    @NotBlank
    private Dierenarts dierenarts;

    @NotBlank
    private Klant klant;

}

