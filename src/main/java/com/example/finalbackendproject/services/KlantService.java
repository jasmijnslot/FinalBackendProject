package com.example.finalbackendproject.services;

import com.example.finalbackendproject.dtos.KlantDTO;
import com.example.finalbackendproject.models.Klant;
import com.example.finalbackendproject.repositories.KlantRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KlantService {


    private KlantRepository klantRepository;

    public KlantService(KlantRepository klantRepository) {
        this.klantRepository = klantRepository;
    }

    public KlantDTO nieuweKlant(KlantDTO klantDTO){
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
            klantenDTOs.add(klantDTO);
        }
        return klantenDTOs;
    }

    public KlantDTO klantPerId(Long id){
        Optional<Klant> optionalKlant = klantRepository.findById(id);
        if(optionalKlant.isEmpty()){
            throw new RuntimeException();
        }
        Klant klant = optionalKlant.get();
        KlantDTO klantDTO = transferKlantToDto(klant);
        return klantDTO;
    }

    public String verwijderKLant(Long id){
        klantRepository.deleteById(id);
        return "Klant is verwijderd";
    }

    public KlantDTO updateKlant(KlantDTO klantDTO, Long id){
        Optional<Klant> optionalKlant = klantRepository.findById(id);
        if(optionalKlant.isEmpty()){
            throw new RuntimeException();
        }
        Klant klant = optionalKlant.get();
        klant.setTelefoonNr(klantDTO.getTelefoonNr());
        klant.setAchterNaam(klantDTO.getAchterNaam());
        klant.setEmail(klantDTO.getEmail());
        klant.setPostcode(klantDTO.getPostcode());
        klant = klantRepository.save(klant);
        return transferKlantToDto(klant);
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
        if(klant.getAfspraken() != null){
            klantDTO.setAfspraken(klant.getAfspraken());
        }
        if(klant.getDieren() != null){
            klantDTO.setDieren(klant.getDieren());
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
        klant.setDieren(klantDTO.getDieren());

        return klant;
    }

}

