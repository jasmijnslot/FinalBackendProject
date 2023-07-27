package com.example.finalbackendproject.repositories;

import com.example.finalbackendproject.models.Klant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlantRepository extends JpaRepository<Klant, Long> {
}
