package com.example.finalbackendproject.services;

import com.example.finalbackendproject.dtos.DierenartsDTO;
import com.example.finalbackendproject.models.Dierenarts;
import com.example.finalbackendproject.repositories.DierenartsRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class DierenartsService {

    private DierenartsRepository dierenartsRepository;

    public DierenartsService(DierenartsRepository dierenartsRepository) {
        this.dierenartsRepository = dierenartsRepository;
    }

    public DierenartsDTO nieuweDierenarts(DierenartsDTO dierenartsDTO){
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

    public DierenartsDTO dierenartsPerId(Long id){
        Optional<Dierenarts> optionalDierenarts = dierenartsRepository.findById(id);
        if(optionalDierenarts.isEmpty()){
            throw new RuntimeException();
        }
        Dierenarts dierenarts = optionalDierenarts.get();
        DierenartsDTO dierenartsDTO = transferDierenartsToDto(dierenarts);
        return dierenartsDTO;
    }

    public String verwijderDierenarts(Long id){
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

