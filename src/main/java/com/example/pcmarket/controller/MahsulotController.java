package com.example.pcmarket.controller;

import com.example.pcmarket.payload.ApiResponse;
import com.example.pcmarket.payload.NotebookDto;
import com.example.pcmarket.service.MahsulotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Mahsulot")
public class MahsulotController {
    @Autowired
    MahsulotService mahsulotService;
    @PreAuthorize(value = "hasAuthority('ADD')")
    @PostMapping("/AddNotebook")
    public HttpEntity<?> AddNoteBook(@RequestBody NotebookDto dto){
        ApiResponse apiResponse=mahsulotService.addNotebook(dto);
        return ResponseEntity.status(apiResponse.isHolat()? HttpStatus.OK:HttpStatus.ALREADY_REPORTED).body(apiResponse.getXabar());
    }
    @PreAuthorize(value = "hasAuthority('IDREAD')")
    @GetMapping("/getIdNotebook/{id}")
    public HttpEntity<?> GetIdNoteBook(@PathVariable Integer id){
        ApiResponse apiResponse=mahsulotService.getidNotebook(id);
        return ResponseEntity.status(apiResponse.isHolat()?HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
    @PreAuthorize(value = "hasAuthority('READ')")
    @GetMapping("/GetNotebook")
    public HttpEntity<?> GetNoteBook(){
        ApiResponse apiResponse=mahsulotService.getNotebook();
        return ResponseEntity.status(apiResponse.isHolat()?HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
    @PreAuthorize(value = "hasAuthority('DELETE')")
    @DeleteMapping("/DeleteNotebook/{id}")
    public HttpEntity<?> DeleteNoteBook(@PathVariable Integer id){
        ApiResponse apiResponse=mahsulotService.deleteNotebook(id);
        return ResponseEntity.status(apiResponse.isHolat()?HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
    @PreAuthorize(value = "hasAuthority('PUT')")
    @PutMapping("/editNotebook/{id}")
    public HttpEntity<?> EditNotebook(@PathVariable Integer id, @RequestBody NotebookDto dto){
        ApiResponse apiResponse=mahsulotService.editNotebook(id, dto);
        return ResponseEntity.status(apiResponse.isHolat()?HttpStatus.OK:HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
}
