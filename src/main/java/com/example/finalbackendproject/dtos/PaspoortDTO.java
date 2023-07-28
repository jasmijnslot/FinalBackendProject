package com.example.finalbackendproject.dtos;

import com.example.finalbackendproject.models.Dier;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
public class PaspoortDTO {

    private Long id;

    @NotBlank
    private Date afgifteDatum;

    @NotBlank
    private String nummer;

    private Dier dier;

    //@NotBlank
    //private String contentType;

    //private byte[] paspoortScan;


}

