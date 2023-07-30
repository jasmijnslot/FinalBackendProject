package com.example.finalbackendproject.services;

import com.example.finalbackendproject.dtos.PaspoortDTO;
import com.example.finalbackendproject.models.Paspoort;
import com.example.finalbackendproject.repositories.PaspoortRepository;
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
class PaspoortServiceTest  {

    @Mock
    PaspoortRepository paspoortrepository;

    @InjectMocks
    PaspoortService paspoortservice;

    Paspoort paspoort1;
    PaspoortDTO paspoortdto;



    @BeforeEach
    void Setup(){
        paspoort1 = new Paspoort();
        paspoort1.setId(1L);
        paspoort1.setNummer("198254823");
        paspoort1.setAfgifteDatum(null);
        paspoort1.setDier(null);

        paspoortdto = new PaspoortDTO();
        paspoortdto.setId(1L);
        paspoortdto.setNummer("198254823");
        paspoortdto.setAfgifteDatum(null);
        paspoortdto.setDier(null);

    }
    @Test
    void nieuwPaspoort() {

    }

    @Test
    void allePaspoorten() {
        List<Paspoort> actualList = new ArrayList<>();
        actualList.add(paspoort1);

        List<PaspoortDTO> expectedList = new ArrayList<>();
        expectedList.add(paspoortdto);

        when(paspoortrepository.findAll()).thenReturn(actualList);

        List <PaspoortDTO> allpaspoorten = paspoortservice.allePaspoorten();

        assertEquals(expectedList.get(0).getNummer(), allpaspoorten.get(0).getNummer());


    }

    @Test
    void paspoortPerId() {
        when(paspoortrepository.findById(any())).thenReturn(Optional.of(paspoort1));
        PaspoortDTO paspoortDTOreturn = paspoortservice.paspoortPerId(1L);
        assertEquals(paspoortDTOreturn.getNummer(), paspoortdto.getNummer());

    }

    @Test
    void paspoortPerIdExeption(){
        assertThrows(RuntimeException.class, () -> paspoortservice.paspoortPerId(100L));
    }

    @Test
    void verwijderPaspoort() {
        when(paspoortrepository.existsById(1L)).thenReturn(true);
        when(paspoortrepository.findById(1L)).thenReturn(Optional.of(paspoort1));
        paspoortservice.verwijderPaspoort(1L);
        verify(paspoortrepository).delete(paspoort1);
    }

    @Test
    void updatePaspoort() {
    }


}