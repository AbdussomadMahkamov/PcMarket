package com.example.pcmarket.repository;

import com.example.pcmarket.entity.Categoriya;
import com.example.pcmarket.entity.Mahsulot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MahsulotRepository extends JpaRepository<Mahsulot, Integer> {
    boolean existsByVideokartaAndEkranDioganalAndEkranOlchamAndProtsessorAndRamAndQattiqDiskAndSistemaAndCategoriyaAndNarxi(String videokarta, String ekranDioganal, String ekranOlcham, String protsessor, String ram, String qattiqDisk, String sistema, Categoriya categoriya, double narxi);
    boolean existsByMatPlataAndSovutishTizimiAndVideokartaAndProtsessorAndRamAndQattiqDiskAndQuvvatManbaiAndSsdAndKeysAndSistemaAndNarxiAndCategoriya(String matPlata, String sovutishTizimi, String videokarta, String protsessor, String ram, String qattiqDisk, String quvvatManbai, String ssd, String keys, String sistema, double narxi, Categoriya categoriya);
    boolean existsByMatPlataAndSovutishTizimiAndProtsessorAndRamAndSsdAndQuvvatManbaiAndKeysAndSistemaAndNarxiAndCategoriya(String matPlata, String sovutishTizimi, String protsessor, String ram, String ssd, String quvvatManbai, String keys, String sistema, double narxi, Categoriya categoriya);
    boolean existsByVideokartaAndEkranDioganalAndEkranOlchamAndProtsessorAndRamAndQattiqDiskAndSsdAndSistemaAndNarxiAndCategoriya(String videokarta, String ekranDioganal, String ekranOlcham, String protsessor, String ram, String qattiqDisk, String ssd, String sistema, double narxi, Categoriya categoriya);
    boolean existsByBrendAndEkranDioganalAndEkranOlchamAndVideoUlagichAndMatritsaAndEkranQayrilishAndEkranChastotasiAndJavobVaqtiAndNarxiAndCategoriya(String brend, String ekranDioganal, String ekranOlcham, String videoUlagich, String matritsa, String ekranQayrilish, String ekranChastotasi, String javobVaqti, double narxi, Categoriya categoriya);
    boolean existsByBrendAndPechatRangiAndQurilmaFunksiyasiAndChopQilishTexnologiyasiAndMaxFormatAndDupleksChopetishAndUlanishAndNarxiAndCategoriya(String brend, String pechatRangi, String qurilmaFunksiyasi, String chopQilishTexnologiyasi, String maxFormat, String dupleksChopetish, String ulanish, double narxi, Categoriya categoriya);
}
