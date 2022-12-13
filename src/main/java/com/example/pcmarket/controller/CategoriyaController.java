package com.example.pcmarket.controller;

import com.example.pcmarket.entity.Categoriya;
import com.example.pcmarket.payload.ApiResponse;
import com.example.pcmarket.service.CategoriyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Categoriya")
public class CategoriyaController {
    @Autowired
    CategoriyaService service;
    @PreAuthorize(value = "hasAuthority('ADD')")
    @PostMapping("/addCategoriya")
    public HttpEntity<?> AddCategoriya(@RequestBody Categoriya categoriya){
        ApiResponse apiResponse=service.addCategoriya(categoriya);
        return ResponseEntity.status(apiResponse.isHolat() ? HttpStatus.OK : HttpStatus.ALREADY_REPORTED).body(apiResponse.getXabar());
    }
    @PreAuthorize(value = "hasAuthority('PUT')")
    @PutMapping("/editCategoriya/{id}")
    public HttpEntity<?> EditCategoriya(@PathVariable Integer id, @RequestBody Categoriya categoriya){
        ApiResponse apiResponse=service.editCategoriya(id, categoriya);
        return ResponseEntity.status(apiResponse.isHolat() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
    @PreAuthorize(value = "hasAuthority('READ')")
    @GetMapping("/getNotebook")
    public HttpEntity<?> GetNotebook(){
        ApiResponse apiResponse=service.getCategoriya();
        return ResponseEntity.status(apiResponse.isHolat() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
    @PreAuthorize(value = "hasAuthority('IDREAD')")
    @GetMapping("/getIdNotebook/{id}")
    public HttpEntity<?> GetIdNotebook(@PathVariable Integer id){
        ApiResponse apiResponse=service.getIdCategoriya(id);
        return ResponseEntity.status(apiResponse.isHolat() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
    @PreAuthorize(value = "hasAuthority('DELETE')")
    @DeleteMapping("/deleteNotebook/{id}")
    public HttpEntity<?> DeleteNotebook(@PathVariable Integer id){
        ApiResponse apiResponse=service.deleteCategoriya(id);
        return ResponseEntity.status(apiResponse.isHolat() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
}
