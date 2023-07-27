package com.example.finalbackendproject.controllers;

import com.example.finalbackendproject.dtos.AfspraakDTO;
import com.example.finalbackendproject.services.AfspraakService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AfspraakController {

    @Autowired
    private AfspraakService afspraakService;

    @PostMapping("/afspraken")
    public AfspraakDTO nieuweAfspraak(@RequestBody AfspraakDTO afspraakDTO){
        return afspraakService.nieuweAfspraak(afspraakDTO);
    }

    @GetMapping("/afspraken")
    public List<AfspraakDTO> alleAfspraken(){
        return afspraakService.alleAfspraken();
    }

    @GetMapping("/afspraken/{id}")
    public AfspraakDTO afspraakPerId(@PathVariable Long id) {
        return afspraakService.afspraakPerId(id);
    }

    @DeleteMapping("/afspraken/{id}")
    public String verwijderPerId(@PathVariable Long id) {
        return afspraakService.verwijderAfspraak(id);
    }


}
