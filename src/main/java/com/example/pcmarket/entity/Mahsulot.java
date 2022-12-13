package com.example.pcmarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Mahsulot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String matPlata;
    private String sovutishTizimi;
    private String videokarta;
    private String protsessor;
    private String ram;
    private String qattiqDisk;
    private String ssd;
    private String keys;
    private String sistema;
    private String quvvatManbai;
    private String ekranDioganal;
    private String ekranOlcham;
    private String brend;
    private String videoUlagich;
    private String matritsa;
    private String ekranQayrilish;
    private String ekranChastotasi;
    private String javobVaqti;
    private String pechatRangi;
    private String qurilmaFunksiyasi;
    private String chopQilishTexnologiyasi;
    private String maxFormat;
    private String dupleksChopetish;
    private String ulanish;
    private double narxi;
    @ManyToOne
    Categoriya categoriya;
}
