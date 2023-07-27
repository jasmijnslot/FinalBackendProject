package com.example.finalbackendproject.services;

import com.example.finalbackendproject.dtos.KlantDTO;
import com.example.finalbackendproject.models.Klant;
import com.example.finalbackendproject.repositories.KlantRepository;
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
public class KlantService {

    @Autowired
    private KlantRepository klantRepository;

    public KlantDTO nieuweKlant(@RequestBody KlantDTO klantDTO){
        Klant klant = transferDtoToKlant(klantDTO);
        klantRepository.save(klant);
        KlantDTO klantDTO1 = transferKlantToDto(klant);
        return klantDTO1;
    }

    public List<KlantDTO> alleKlanten(){
        List<Klant> klanten = klantRepository.findAll();
        List<KlantDTO> klantenDTOs = new ArrayList<>();
        for( Klant klant:klanten) {
            KlantDTO klantDTO = transferKlantToDto(klant);
        }
        return klantenDTOs;
    }

    public KlantDTO klantPerId(@PathVariable Long id){
        Optional<Klant> optionalKlant = klantRepository.findById(id);
        if(optionalKlant.isEmpty()){
            throw new RuntimeException();
        }
        Klant klant = optionalKlant.get();
        KlantDTO klantDTO = transferKlantToDto(klant);
        return klantDTO;
    }

    public String verwijderKLant(@PathVariable Long id){
        klantRepository.deleteById(id);
        return "Klant is verwijderd";
    }

    private KlantDTO transferKlantToDto(Klant klant){
        KlantDTO klantDTO = new KlantDTO();

        if(klant.getAchterNaam() != null){
            klantDTO.setAchterNaam(klant.getAchterNaam());
        }
        if(klant.getEmail() != null){
            klantDTO.setEmail(klant.getEmail());
        }
        if(klant.getPostcode() != null){
            klantDTO.setPostcode(klant.getPostcode());
        }
        if(klant.getId() != null){
            klantDTO.setId(klant.getId());
        }
        if(klant.getTelefoonNr() != null){
            klantDTO.setTelefoonNr(klant.getTelefoonNr());
        }
        return klantDTO;
    }

    private Klant transferDtoToKlant(KlantDTO klantDTO){
        Klant klant = new Klant();

        klant.setAchterNaam(klantDTO.getAchterNaam());
        klant.setEmail(klantDTO.getEmail());
        klant.setId(klantDTO.getId());
        klant.setPostcode(klantDTO.getPostcode());
        klant.setTelefoonNr(klantDTO.getTelefoonNr());

        return klant;
    }

}

