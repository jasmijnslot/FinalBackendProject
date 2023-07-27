package com.example.finalbackendproject.services;

import com.example.finalbackendproject.dtos.DierDTO;
import com.example.finalbackendproject.models.Dier;
import com.example.finalbackendproject.repositories.DierRepository;
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
public class DierService {

    @Autowired
    private DierRepository dierRepository;

    public DierDTO nieuwDier(@RequestBody DierDTO dierDTO) {
        Dier dier = transferDtoToDier(dierDTO);
        dierRepository.save(dier);
        DierDTO dierDTO1 = transferDierToDto(dier);
        return dierDTO1;
    }

    public List<DierDTO> alleDieren() {
        List<Dier> dieren = dierRepository.findAll();
        List<DierDTO> dierenDTOS = new ArrayList<>();
        for (Dier dier:dieren) {
            DierDTO dierDTO = transferDierToDto(dier);
            dierenDTOS.add(dierDTO);
        }
        return dierenDTOS;
    }

    public DierDTO dierPerId(@PathVariable Long id) {
        Optional<Dier> optionalDier = dierRepository.findById(id);
        if (optionalDier.isEmpty()) {
            throw new RuntimeException();
        }
        Dier dier = optionalDier.get();
        DierDTO dierDTO = transferDierToDto(dier);
        return dierDTO;
    }

    public String verwijderDier(@PathVariable Long id) {
        dierRepository.deleteById(id);
        return "dier is verwijderd";
    }

    private DierDTO transferDierToDto(Dier dier) {
        DierDTO dierDto = new DierDTO();

        if (dier.getNaam() != null) {
            dierDto.setNaam(dier.getNaam());
        }
        if (dier.getGeboorteDatum() != null) {
            dierDto.setGeboorteDatum(dier.getGeboorteDatum());
        }
        if (dier.getSoort() != null) {
            dierDto.setSoort(dier.getSoort());
        }
        if (dier.getAfspraak() != null) {
            dierDto.setAfspraak(dier.getAfspraak());
        }
        if (dier.getId() != null) {
            dierDto.setId(dier.getId());
        }
        return dierDto;
    }

    private Dier transferDtoToDier(DierDTO dierDto){
        Dier dier = new Dier();

        dier.setNaam(dierDto.getNaam());
        dier.setGeboorteDatum(dierDto.getGeboorteDatum());
        dier.setSoort(dierDto.getSoort());
        dier.setAfspraak(dierDto.getAfspraak());

        return dier;
    }
}


