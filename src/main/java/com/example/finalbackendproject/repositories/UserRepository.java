package com.example.finalbackendproject.repositories;

import com.example.finalbackendproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
