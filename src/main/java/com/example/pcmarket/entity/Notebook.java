package com.example.pcmarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String videkarta;
    @Column(nullable = false)
    private String ekranDioganal;
    @Column(nullable = false)
    private String ekranOlchami;
    @Column(nullable = false)
    private String protsessor;
    @Column(nullable = false)
    private String operativka;
    @Column(nullable = false)
    private String xotira;
    @Column(nullable = false)
    private String operatsionSistema;
}
