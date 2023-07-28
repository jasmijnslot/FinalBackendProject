package com.example.finalbackendproject.controllers;

import com.example.finalbackendproject.dtos.KlantDTO;
import com.example.finalbackendproject.services.KlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class KlantController {

    @Autowired
    private KlantService klantService;

    @PostMapping("/klanten")
    public KlantDTO nieuweKlant(@RequestBody KlantDTO klantDTO){
        return klantService.nieuweKlant(klantDTO);
    }

    @GetMapping("/klanten")
    public List<KlantDTO> alleKlanten(){
        return klantService.alleKlanten();
    }

    @GetMapping("/klanten/{id}")
    public KlantDTO klantPerId(@PathVariable Long id){
        return klantService.klantPerId(id);
    }

    @DeleteMapping("/klanten/{id}")
    public String verwijderKlant(@PathVariable Long id){
        return klantService.verwijderKLant(id);
    }


    @PutMapping("/klanten/{id}")
    public KlantDTO updateKlant(@RequestBody KlantDTO klantDTO, @PathVariable Long id){
        return klantService.updateKlant(klantDTO, id);
    }






}
