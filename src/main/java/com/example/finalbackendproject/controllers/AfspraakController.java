package com.example.finalbackendproject.controllers;

import com.example.finalbackendproject.dtos.AfspraakDTO;
import com.example.finalbackendproject.services.AfspraakService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/afspraken")
public class AfspraakController {

    @Autowired
    private AfspraakService afspraakService;

    @PostMapping("/{dier_id}")
    public AfspraakDTO nieuweAfspraak(@RequestBody AfspraakDTO afspraakDTO, @PathVariable Long dier_id){
        return afspraakService.nieuweAfspraak(afspraakDTO, dier_id);
    }

    @GetMapping("")
    public List<AfspraakDTO> alleAfspraken(){
        return afspraakService.alleAfspraken();
    }

    @GetMapping("/{id}")
    public AfspraakDTO afspraakPerId(@PathVariable Long id) {
        return afspraakService.afspraakPerId(id);
    }

    @DeleteMapping("/{id}")
    public String verwijderPerId(@PathVariable Long id) {
        return afspraakService.verwijderAfspraak(id);
    }

    @PutMapping("/{id}")
    public AfspraakDTO updateAfspraak(@RequestBody AfspraakDTO afspraakDTO, @PathVariable Long id){
        return afspraakService.updateAfspraak(afspraakDTO, id);
    }

}
