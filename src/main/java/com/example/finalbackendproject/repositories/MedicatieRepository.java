package com.example.finalbackendproject.repositories;

import com.example.finalbackendproject.models.Medicatie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicatieRepository extends JpaRepository<Medicatie, Long> {
}
