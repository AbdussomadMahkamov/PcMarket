package com.example.pcmarket.repository;

import com.example.pcmarket.entity.Categoriya;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriyaRepository extends JpaRepository<Categoriya, Integer> {
    boolean existsByNomi(String nomi);
}
