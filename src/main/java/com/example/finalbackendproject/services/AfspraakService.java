package com.example.finalbackendproject.services;
import com.example.finalbackendproject.dtos.AfspraakDTO;
import com.example.finalbackendproject.models.Afspraak;
import com.example.finalbackendproject.models.Dier;
import com.example.finalbackendproject.repositories.AfspraakRepository;
import com.example.finalbackendproject.repositories.DierRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AfspraakService {


    private final AfspraakRepository afspraakRepository;
    private final DierRepository dierRepository;

    public AfspraakService(AfspraakRepository afspraakRepository, DierRepository dierRepository) {
        this.afspraakRepository = afspraakRepository;
        this.dierRepository = dierRepository;
    }

    public AfspraakDTO nieuweAfspraak(AfspraakDTO afspraakDTO, Long dier_id) {
        Optional<Dier> optionalDier = dierRepository.findById(dier_id);
        if(optionalDier.isEmpty()){
            throw new RuntimeException();
        }
        Dier dier = optionalDier.get();
        Afspraak afspraak = transferDtoToAfspraak(afspraakDTO);
        afspraak.setDier(dier);
        afspraakRepository.save(afspraak);
        AfspraakDTO afspraakDTO1 = transferAfspraakToDto(afspraak);

        return afspraakDTO1;
    }

    public List<AfspraakDTO> alleAfspraken(){
        List<Afspraak> afspraken = afspraakRepository.findAll();
        List<AfspraakDTO>afsprakenDtos = new ArrayList<>();
        for(Afspraak afspraak:afspraken) {
            AfspraakDTO afspraakDTO = transferAfspraakToDto(afspraak);
            afsprakenDtos.add(afspraakDTO);
        }
        return afsprakenDtos;
    }

    public AfspraakDTO afspraakPerId(@PathVariable Long id) {
        Optional<Afspraak> optionalAfspraak = afspraakRepository.findById(id);
        if(optionalAfspraak.isEmpty()){
            throw new RuntimeException();
        }
        Afspraak afspraak = optionalAfspraak.get();
        AfspraakDTO afspraakDTO = transferAfspraakToDto(afspraak);
        return afspraakDTO;
    }

    public String verwijderAfspraak(@PathVariable Long id) {
        afspraakRepository.deleteById(id);
        return "afspraak is verwijderd";
    }


    private AfspraakDTO transferAfspraakToDto(Afspraak afspraak) {
        AfspraakDTO afspraakDTO = new AfspraakDTO();

        if (afspraak.getDatum() != null) {
            afspraakDTO.setDatum(afspraak.getDatum());
        }
        if (afspraak.getReden() != null) {
            afspraakDTO.setReden(afspraak.getReden());
        }
        if (afspraak.getDier() != null) {
            afspraakDTO.setDier(afspraak.getDier());
        }
        if (afspraak.getId() != null) {
            afspraakDTO.setId(afspraak.getId());
        }
        return afspraakDTO;
    }

    private Afspraak transferDtoToAfspraak(AfspraakDTO afspraakDTO){
        Afspraak afspraak = new Afspraak();

        afspraak.setDatum(afspraakDTO.getDatum());
        afspraak.setDier(afspraakDTO.getDier());
        afspraak.setReden(afspraakDTO.getReden());
        afspraak.setId(afspraakDTO.getId());

        return afspraak;
    }

}

