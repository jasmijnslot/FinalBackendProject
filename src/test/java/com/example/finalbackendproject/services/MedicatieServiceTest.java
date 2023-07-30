package com.example.finalbackendproject.services;

import com.example.finalbackendproject.dtos.MedicatieDTO;
import com.example.finalbackendproject.dtos.PaspoortDTO;
import com.example.finalbackendproject.models.Medicatie;
import com.example.finalbackendproject.models.Paspoort;
import com.example.finalbackendproject.repositories.MedicatieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MedicatieServiceTest {


    @Mock
    MedicatieRepository medicatieRepository;

    @InjectMocks
    MedicatieService medicatieService;

    Medicatie medicatie1;

    MedicatieDTO medicatieDTO;

    @BeforeEach
    void Setup(){
        medicatie1 = new Medicatie();
        medicatie1.setId(1l);
        medicatie1.setDosering("dosering");
        medicatie1.setOpmerking("Geen opmerking");
        medicatie1.setNaam("paracetamol");
        medicatie1.setDieren(null);

        medicatieDTO = new MedicatieDTO();
        medicatieDTO.setId(1L);
        medicatieDTO.setDosering("dosering");
        medicatieDTO.setOpmerking("Geen opmerking");
        medicatieDTO.setNaam("paracetamol");
        medicatieDTO.setDieren(null);
    }


    @Test
    void nieuweMedicatie() {
    }

    @Test
    void alleMedicaties() {
        List<Medicatie> actualList = new ArrayList<>();
        actualList.add(medicatie1);

        List<MedicatieDTO> expectedList = new ArrayList<>();
        expectedList.add(medicatieDTO);

        when(medicatieRepository.findAll()).thenReturn(actualList);

        List <MedicatieDTO> allpaspoorten = medicatieService.alleMedicaties();

        assertEquals(expectedList.get(0).getId(), allpaspoorten.get(0).getId());


    }

    @Test
    void medicatiePerId() {
        when(medicatieRepository.findById(any())).thenReturn(Optional.of(medicatie1));
        MedicatieDTO medicatieDTO1 = medicatieService.medicatiePerId(1L);
        assertEquals(medicatieDTO1.getNaam(), medicatieDTO.getNaam());

    }

    @Test
    void verwijderMedicatie() {
        when(medicatieRepository.existsById(1L)).thenReturn(true);
        when(medicatieRepository.findById(1L)).thenReturn(Optional.of(medicatie1));
        medicatieService.verwijderMedicatie(1L);
        verify(medicatieRepository).delete(medicatie1);

    }

    @Test
    void updateMedicatie() {
    }
}