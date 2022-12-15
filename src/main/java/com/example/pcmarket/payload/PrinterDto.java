package com.example.pcmarket.payload;

import lombok.Data;

@Data
public class PrinterDto {
    private String brend;
    private String pechatRangi;
    private String qurilmaFunksiyasi;
    private String chopQilishTexnologiyasi;
    private String maxFormat;
    private String dupleksChopetish;
    private String ulanish;
    private double narxi;
    private Integer categoriyaId;
//    "brend": "Canon",
//    "pechatRangi": "Oq-Qora",
//    "qurilmaFunksiyasi": "Printer",
//    "chopQilishTexnologiyasi": "Lazerli",
//    "maxFormat": "A4",
//    "dupleksChopetish": "Yo'q",
//    "ulanish": "USB 2.0",
//    "narxi": 250,
//    "categoriyaId": 6
}
