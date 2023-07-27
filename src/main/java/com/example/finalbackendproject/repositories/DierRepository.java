package com.example.finalbackendproject.repositories;

import com.example.finalbackendproject.models.Dier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DierRepository extends JpaRepository<Dier, Long> {
}