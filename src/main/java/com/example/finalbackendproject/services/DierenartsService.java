package com.example.finalbackendproject.services;

import com.example.finalbackendproject.dtos.DierenartsDTO;
import com.example.finalbackendproject.models.Dierenarts;
import com.example.finalbackendproject.repositories.DierenartsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DierenartsService {

    @Autowired
    private DierenartsRepository dierenartsRepository;

    public DierenartsDTO nieuweDierenarts(@RequestBody DierenartsDTO dierenartsDTO){
        Dierenarts dierenarts = transferDtoToDierenarts(dierenartsDTO);
        dierenartsRepository.save(dierenarts);
        DierenartsDTO dierenartsDTO1 = transferDierenartsToDto(dierenarts);
        return dierenartsDTO1;
    }

    public List<DierenartsDTO> alleDierenartsen(){
        List<Dierenarts> dierenartsen = dierenartsRepository.findAll();
        List<DierenartsDTO> dierenartsDTOS = new ArrayList<>();
        for (Dierenarts dierenarts:dierenartsen){
            DierenartsDTO dierenartsDTO = transferDierenartsToDto(dierenarts);
            dierenartsDTOS.add(dierenartsDTO);
        }
        return dierenartsDTOS;
    }

    public DierenartsDTO dierenartsPerId(@PathVariable Long id){
        Optional<Dierenarts> optionalDierenarts = dierenartsRepository.findById(id);
        if(optionalDierenarts.isEmpty()){
            throw new RuntimeException();
        }
        Dierenarts dierenarts = optionalDierenarts.get();
        DierenartsDTO dierenartsDTO = transferDierenartsToDto(dierenarts);
        return dierenartsDTO;
    }

    public String verwijderDierenarts(@PathVariable Long id){
        dierenartsRepository.deleteById(id);
        return "Dierenarts is verwijderd";
    }

    private DierenartsDTO transferDierenartsToDto(Dierenarts dierenarts) {
        DierenartsDTO dierenartsDTO = new DierenartsDTO();

        if (dierenarts.getAchternaam() != null) {
            dierenartsDTO.setAchternaam(dierenarts.getAchternaam());
        }
        if (dierenarts.getId() != null) {
            dierenartsDTO.setId(dierenarts.getId());
        }
        if (dierenarts.getSpecialisatie() != null) {
            dierenartsDTO.setSpecialisatie(dierenarts.getSpecialisatie());
        }
        if (dierenarts.getTelefoonNr() != 0) {
            dierenartsDTO.setTelefoonNr(dierenarts.getTelefoonNr());
        }
        return dierenartsDTO;
    }

    private Dierenarts transferDtoToDierenarts(DierenartsDTO dierenartsDTO){
        Dierenarts dierenarts = new Dierenarts();

        dierenarts.setTelefoonNr(dierenartsDTO.getTelefoonNr());
        dierenarts.setAchternaam(dierenartsDTO.getAchternaam());
        dierenarts.setId(dierenartsDTO.getId());
        dierenarts.setSpecialisatie(dierenartsDTO.getSpecialisatie());

        return dierenarts;
    }

}

