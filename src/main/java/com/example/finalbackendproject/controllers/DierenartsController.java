package com.example.finalbackendproject.controllers;

import com.example.finalbackendproject.dtos.DierenartsDTO;
import com.example.finalbackendproject.services.DierenartsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class DierenartsController {

    @Autowired
    private DierenartsService dierenartsService;

    @PostMapping("/dierenartsen")
    public DierenartsDTO nieuweDierenarts(@RequestBody DierenartsDTO dierenartsDTO){
        return dierenartsService.nieuweDierenarts(dierenartsDTO);
    }

    @GetMapping("/dierenartsen")
    public List<DierenartsDTO> alleDierenartsen(){
        return dierenartsService.alleDierenartsen();
    }

    @GetMapping("/dierenartsen/{id}")
    public DierenartsDTO dierenartsPerId(@PathVariable Long id){
        return dierenartsService.dierenartsPerId(id);
    }

    @DeleteMapping("/dierenartsen/{id}")
    public String verwijderDierenarts(@PathVariable Long id){
        return dierenartsService.verwijderDierenarts(id);
    }

    @PutMapping("/dierenartsen/{id}")
    public DierenartsDTO updateDierenarts(@RequestBody DierenartsDTO dierenartsDTO, @PathVariable Long id){
        return dierenartsService.updateDierenarts(dierenartsDTO, id);
    }

}

