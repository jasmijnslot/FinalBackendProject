package com.example.finalbackendproject.repositories;

import com.example.finalbackendproject.models.Paspoort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaspoortRepository extends JpaRepository<Paspoort, Long> {

}
