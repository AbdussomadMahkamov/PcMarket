package com.example.pcmarket.repository;

import com.example.pcmarket.entity.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotebookRepository extends JpaRepository<Notebook, Integer> {
    boolean existsByVidekartaAndEkranDioganalAndEkranOlchamiAndProtsessorAndOperativkaAndXotiraAndOperatsionSistema(String videkarta, String ekranDioganal, String ekranOlchami, String protsessor, String operativka, String xotira, String operatsionSistema);
}