package com.example.finalbackendproject.dtos;

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

    @NotBlank
    private String contentType;

    private byte[] paspoortScan;


}

