package com.example.pcmarket.controller;

import com.example.pcmarket.entity.Notebook;
import com.example.pcmarket.payload.ApiResponse;
import com.example.pcmarket.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Notebook")
public class NotebookController {
    @Autowired
    NotebookService notebookService;
    @PostMapping("/addnotebook")
    public HttpEntity<?> AddNotebook(@RequestBody Notebook notebook){
        ApiResponse apiResponse=notebookService.addNotebook(notebook);
        return ResponseEntity.status(apiResponse.isHolat() ? HttpStatus.OK : HttpStatus.ALREADY_REPORTED).body(apiResponse.getXabar());
    }
    @PutMapping("/editNotebook/{id}")
    public HttpEntity<?> EditNotebook(@PathVariable Integer id,@RequestBody Notebook notebook){
        ApiResponse apiResponse=notebookService.editNotebook(id,notebook);
        return ResponseEntity.status(apiResponse.isHolat() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
    @GetMapping("/getNotebook")
    public HttpEntity<?> GetNotebook(){
        ApiResponse apiResponse=notebookService.getNotebook();
        return ResponseEntity.status(apiResponse.isHolat() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
    @GetMapping("/getIdNotebook/{id}")
    public HttpEntity<?> GetIdNotebook(@PathVariable Integer id){
        ApiResponse apiResponse=notebookService.getIdNotebook(id);
        return ResponseEntity.status(apiResponse.isHolat() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
    @DeleteMapping("/deleteNotebook/{id}")
    public HttpEntity<?> DeleteNotebook(@PathVariable Integer id){
        ApiResponse apiResponse=notebookService.deleteNotebook(id);
        return ResponseEntity.status(apiResponse.isHolat() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(apiResponse.getXabar());
    }
}
