package com.example.finalbackendproject.repositories;

import com.example.finalbackendproject.models.Dierenarts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DierenartsRepository extends JpaRepository<Dierenarts, Long> {

}
