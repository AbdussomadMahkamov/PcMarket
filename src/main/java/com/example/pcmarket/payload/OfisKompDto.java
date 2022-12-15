package com.example.pcmarket.payload;

import lombok.Data;

@Data
public class OfisKompDto {
    private String matPlata;
    private String sovutishTizimi;
    private String protsessor;
    private String ram;
    private String quvvatManbai;
    private String ssd;
    private String keys;
    private String sistema;
    private double narxi;
    private Integer categoriyaId;
//    "matPlata": "ASUS 7478S",
//    "sovutishTizimi": "ASUS ZW777",
//    "protsessor": "Intel i5 1275",
//    "ram": "8gb",
//    "quvvatManbai": "Asus z544",
//    "ssd": "500gb SSD",
//    "keys": "ASUS M756",
//    "sistema": "Windows 10",
//    "narxi": 756,
//    "categoriyaId": 3
}
