package com.example.finalbackendproject.controllers;

import com.example.finalbackendproject.dtos.DierDTO;
import com.example.finalbackendproject.services.DierService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class DierController {

    @Autowired
    private DierService dierService;

    @PostMapping("/dieren")
    public DierDTO nieuwDier(@RequestBody DierDTO dierDTO) {

        return dierService.nieuwDier(dierDTO);
    }

    @GetMapping("/dieren")
    public List<DierDTO> alleDieren(){
        return dierService.alleDieren();
    }

    @GetMapping("/dieren/{id}")
    public DierDTO dierPerId(@PathVariable Long id){
        return dierService.dierPerId(id);
    }

    @DeleteMapping("/dieren/{id}")
    public String verwijderDier(@PathVariable Long id){
        return dierService.verwijderDier(id);
    }

    @PutMapping("/dieren/{id}")
    public DierDTO updateDier(@RequestBody DierDTO dierDTO, @PathVariable Long id){
        return dierService.updateDier(dierDTO, id);
    }

}
