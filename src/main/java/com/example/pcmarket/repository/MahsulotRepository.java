package com.example.pcmarket.repository;

import com.example.pcmarket.entity.Categoriya;
import com.example.pcmarket.entity.Mahsulot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MahsulotRepository extends JpaRepository<Mahsulot, Integer> {
    boolean existsByVideokartaAndEkranDioganalAndEkranOlchamAndProtsessorAndRamAndQattiqDiskAndSistemaAndCategoriya(String videokarta, String ekranDioganal, String ekranOlcham, String protsessor, String ram, String qattiqDisk, String sistema, Categoriya categoriya);
}
