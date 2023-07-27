package com.example.finalbackendproject.repositories;

import com.example.finalbackendproject.models.Afspraak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfspraakRepository extends JpaRepository<Afspraak, Long> {

}

