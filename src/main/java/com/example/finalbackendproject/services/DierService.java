package com.example.finalbackendproject.services;

import com.example.finalbackendproject.dtos.DierDTO;
import com.example.finalbackendproject.models.Dier;
import com.example.finalbackendproject.repositories.DierRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DierService {


    private DierRepository dierRepository;

    public DierService(DierRepository dierRepository) {
        this.dierRepository = dierRepository;
    }

    public DierDTO nieuwDier(DierDTO dierDTO) {
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

    public DierDTO dierPerId(Long id) {
        Optional<Dier> optionalDier = dierRepository.findById(id);
        if (optionalDier.isEmpty()) {
            throw new RuntimeException();
        }
        Dier dier = optionalDier.get();
        DierDTO dierDTO = transferDierToDto(dier);
        return dierDTO;
    }

    public String verwijderDier(Long id) {
        dierRepository.deleteById(id);
        return "dier is verwijderd";
    }

    public DierDTO updateDier(DierDTO dierDTO, Long id){
        Optional<Dier> optionalDier = dierRepository.findById(id);
        if (optionalDier.isEmpty()) {
            throw new RuntimeException();
        }
        Dier dier = optionalDier.get();
        dier.setNaam(dierDTO.getNaam());
        dier.setSoort(dierDTO.getSoort());
        dier.setGeboorteDatum(dierDTO.getGeboorteDatum());
        dier = dierRepository.save(dier);
        return transferDierToDto(dier);
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
            dierDto.setAfspraken(dier.getAfspraak());
        }
        if (dier.getId() != null) {
            dierDto.setId(dier.getId());
        }
        if(dier.getKlant() != null){
            dierDto.setKlant(dier.getKlant());
        }
        if(dier.getMedicaties() != null){
           dierDto.setMedicaties(dier.getMedicaties());
        }
        if(dier.getPaspoort() != null){
            dierDto.setPaspoort(dier.getPaspoort());
        }
        return dierDto;
    }

    private Dier transferDtoToDier(DierDTO dierDto){
        Dier dier = new Dier();

        dier.setNaam(dierDto.getNaam());
        dier.setGeboorteDatum(dierDto.getGeboorteDatum());
        dier.setSoort(dierDto.getSoort());
        dier.setAfspraak(dierDto.getAfspraken());
        dier.setMedicaties(dierDto.getMedicaties());
        dier.setKlant(dierDto.getKlant());
        dier.setPaspoort(dierDto.getPaspoort());

        return dier;
    }
}


