package com.example.finalbackendproject.controllers;

import com.example.finalbackendproject.dtos.MedicatieDTO;
import com.example.finalbackendproject.models.Medicatie;
import com.example.finalbackendproject.services.MedicatieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MedicatieController {

    @Autowired
    private MedicatieService medicatieService;

    @PostMapping("/medicaties")
    public MedicatieDTO nieuweMedicatie(@RequestBody MedicatieDTO medicatieDTO){
        return medicatieService.nieuweMedicatie(medicatieDTO);
    }

    @GetMapping("/medicaties")
    public List<MedicatieDTO> alleMedicatie(){
        return medicatieService.alleMedicaties();
    }

    @GetMapping("/medicaties/{id}")
    public MedicatieDTO medicatiePerId(@PathVariable Long id){
        return medicatieService.medicatiePerId(id);
    }

    @DeleteMapping("/medicaties/{id}")
    public String verwijderMedicatie(@PathVariable Long id){
        return medicatieService.verwijderMedicatie(id);
    }

}

