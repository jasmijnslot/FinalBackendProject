package com.example.finalbackendproject.services;

import com.example.finalbackendproject.dtos.MedicatieDTO;
import com.example.finalbackendproject.models.Medicatie;
import com.example.finalbackendproject.repositories.MedicatieRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicatieService {

    private MedicatieRepository medicatieRepository;

    public MedicatieService(MedicatieRepository medicatieRepository) {
        this.medicatieRepository = medicatieRepository;
    }

    public MedicatieDTO nieuweMedicatie(MedicatieDTO medicatieDTO){
        Medicatie medicatie = transferDtoToMedicatie(medicatieDTO);
        medicatieRepository.save(medicatie);
        MedicatieDTO medicatieDTO1 = transferMedicatieToDTO(medicatie);
        return medicatieDTO1;
    }

    public List<MedicatieDTO> alleMedicaties(){
        List<Medicatie> medicaties = medicatieRepository.findAll();
        List<MedicatieDTO> medicatieDTOS = new ArrayList<>();
        for(Medicatie medicatie:medicaties){
            MedicatieDTO medicatieDTO = transferMedicatieToDTO(medicatie);
            medicatieDTOS.add(medicatieDTO);
        }
        return medicatieDTOS;
    }

    public MedicatieDTO medicatiePerId(Long id) {
        Optional<Medicatie> optionalMedicatie = medicatieRepository.findById(id);
        if(optionalMedicatie.isEmpty()){
            throw new RuntimeException();
        }
        Medicatie medicatie = optionalMedicatie.get();
        MedicatieDTO medicatieDTO = transferMedicatieToDTO(medicatie);
        return medicatieDTO;
    }

    public String verwijderMedicatie(Long id) {
        medicatieRepository.deleteById(id);
        return "Medicatie is verwijderd";
    }

    public MedicatieDTO updateMedicatie(MedicatieDTO medicatieDTO, Long id){
        Optional<Medicatie> optionalMedicatie = medicatieRepository.findById(id);
        if(optionalMedicatie.isEmpty()){
            throw new RuntimeException();
        }
        Medicatie medicatie = optionalMedicatie.get();
        medicatie.setOpmerking(medicatieDTO.getOpmerking());
        medicatie.setDosering(medicatieDTO.getDosering());
        medicatie.setNaam(medicatieDTO.getNaam());
        medicatie = medicatieRepository.save(medicatie);
        return transferMedicatieToDTO(medicatie);
    }

    private MedicatieDTO transferMedicatieToDTO(Medicatie medicatie){
        MedicatieDTO medicatieDTO = new MedicatieDTO();

        if(medicatie.getDosering() != null){
            medicatieDTO.setDosering(medicatie.getDosering());
        }
        if(medicatie.getOpmerking() != null){
            medicatieDTO.setOpmerking(medicatie.getOpmerking());
        }
        if(medicatie.getNaam() != null){
            medicatieDTO.setNaam(medicatie.getNaam());
        }
        if(medicatie.getId() != null){
            medicatieDTO.setId(medicatie.getId());
        }
        return medicatieDTO;
    }

    private Medicatie transferDtoToMedicatie(MedicatieDTO medicatieDTO){
        Medicatie medicatie = new Medicatie();

        medicatie.setDosering(medicatieDTO.getDosering());
        medicatie.setId(medicatieDTO.getId());
        medicatie.setNaam(medicatieDTO.getNaam());
        medicatie.setOpmerking(medicatieDTO.getOpmerking());

        return medicatie;
    }

}

