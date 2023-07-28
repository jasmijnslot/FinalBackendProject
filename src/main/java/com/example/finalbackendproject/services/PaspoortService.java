package com.example.finalbackendproject.services;

import com.example.finalbackendproject.dtos.PaspoortDTO;
import com.example.finalbackendproject.exceptions.FileStorageException;
import com.example.finalbackendproject.models.Paspoort;
import com.example.finalbackendproject.repositories.PaspoortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaspoortService {


    private PaspoortRepository paspoortRepository;

    public PaspoortService(PaspoortRepository paspoortRepository) {
        this.paspoortRepository = paspoortRepository;
    }

    public PaspoortDTO nieuwPaspoort(PaspoortDTO paspoortDTO) {
        Paspoort paspoort = transferDtoToPaspoort(paspoortDTO);
        paspoortRepository.save(paspoort);
        PaspoortDTO paspoortDTO1 = transferPaspoortToDto(paspoort);
        return paspoortDTO1;
    }

    public List<PaspoortDTO> allePaspoorten() {
        List<Paspoort> paspoorten = paspoortRepository.findAll();
        List<PaspoortDTO> paspoortDTOS = new ArrayList<>();
        for(Paspoort paspoort:paspoorten){
            PaspoortDTO paspoortDTO = transferPaspoortToDto(paspoort);
            paspoortDTOS.add(paspoortDTO);
        }
        return paspoortDTOS;
    }

    public PaspoortDTO paspoortPerId(Long id) {
        Optional<Paspoort> optionalPaspoort = paspoortRepository.findById(id);
        if(optionalPaspoort.isEmpty()){
            throw new RuntimeException();
        }
        Paspoort paspoort = optionalPaspoort.get();
        PaspoortDTO paspoortDTO = transferPaspoortToDto(paspoort);
        return paspoortDTO;
    }

    public String verwijderPaspoort(Long id) {
        paspoortRepository.deleteById(id);
        return "Paspoort is verwijderd";
    }

    //public Paspoort paspoortOpslag(MultipartFile file) {
    //    String nummer = StringUtils.cleanPath(file.getOriginalFilename());
     //   try {
    //        Paspoort paspoort = new Paspoort(nummer, file.getContentType(), file.getBytes());
    //        return paspoortRepository.save(paspoort);

     //   } catch (IOException ex) {
     //       throw new FileStorageException("Kon niet opgeslagen worden.", ex);
     //   }

    //}

    //public Paspoort krijgPaspoort(Long id) {
    //    return paspoortRepository.findById(id)
     //           .orElse(null);
   // }
    private PaspoortDTO transferPaspoortToDto(Paspoort paspoort){
        PaspoortDTO paspoortDTO = new PaspoortDTO();

      //  if(paspoort.getPaspoortScan() != null){
       //     paspoortDTO.setPaspoortScan(paspoort.getPaspoortScan());
       // }
        if(paspoort.getAfgifteDatum() != null){
            paspoortDTO.setAfgifteDatum(paspoort.getAfgifteDatum());
        }
        if(paspoort.getNummer() != null){
            paspoortDTO.setNummer(paspoort.getNummer());
        }
    //    if(paspoort.getContentType() != null){
    //        paspoortDTO.setContentType(paspoort.getContentType());
    //    }
        if(paspoort.getId() != null){
            paspoortDTO.setId(paspoort.getId());
        }
        return paspoortDTO;
    }

    private Paspoort transferDtoToPaspoort(PaspoortDTO paspoortDTO){
        Paspoort paspoort = new Paspoort();

        paspoort.setAfgifteDatum(paspoortDTO.getAfgifteDatum());
    //    paspoort.setPaspoortScan(paspoortDTO.getPaspoortScan());
        paspoort.setId(paspoortDTO.getId());
        paspoort.setNummer(paspoortDTO.getNummer());
     //   paspoort.setContentType(paspoortDTO.getContentType());

        return paspoort;
    }
}
