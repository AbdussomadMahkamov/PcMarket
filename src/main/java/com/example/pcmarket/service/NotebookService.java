package com.example.pcmarket.service;

import com.example.pcmarket.entity.Notebook;
import com.example.pcmarket.payload.ApiResponse;
import com.example.pcmarket.repository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotebookService {
    @Autowired
    NotebookRepository notebookRepository;
    public ApiResponse addNotebook(Notebook notebook) {
        boolean b = notebookRepository.existsByVidekartaAndEkranDioganalAndEkranOlchamiAndProtsessorAndOperativkaAndXotiraAndOperatsionSistema(notebook.getVidekarta(), notebook.getEkranDioganal(), notebook.getEkranOlchami(), notebook.getProtsessor(), notebook.getOperativka(), notebook.getXotira(), notebook.getOperatsionSistema());
        if (b){
            return new ApiResponse("Bazada bunday ma'lumot saqlangan",false);
        }
        notebookRepository.save(notebook);
        return new ApiResponse("Bazaga ma'lumot saqlandi",true);
    }

    public ApiResponse editNotebook(Integer id, Notebook notebook) {
        Optional<Notebook> byId = notebookRepository.findById(id);
        if (!byId.isPresent()){
            return new ApiResponse("Bazada bunday idli ma'lumot topilmadi", false);
        }
        Notebook notebook1=byId.get();
        notebook1.setVidekarta(notebook.getVidekarta());
        notebook1.setEkranDioganal(notebook.getEkranDioganal());
        notebook1.setEkranOlchami(notebook.getEkranOlchami());
        notebook1.setProtsessor(notebook.getProtsessor());
        notebook1.setOperativka(notebook.getOperativka());
        notebook1.setXotira(notebook.getXotira());
        notebook1.setOperatsionSistema(notebook.getOperatsionSistema());
        notebookRepository.save(notebook1);
        return new ApiResponse("Ma'lumotrlar tahrirlandi", true);
    }

    public ApiResponse getNotebook() {
        List<Notebook> list=notebookRepository.findAll();
        return new ApiResponse(list.toString(), true);
    }

    public ApiResponse getIdNotebook(Integer id) {
        List<Notebook> list=notebookRepository.findAll();
        for (Notebook notebook : list) {
            if (notebook.getId().equals(id)){
                return new ApiResponse(notebook.toString(), true);
            }
        }
        return new ApiResponse("Bazda bunday idli ma'lumot topilmadi",false);
    }

    public ApiResponse deleteNotebook(Integer id) {
        Optional<Notebook> byId = notebookRepository.findById(id);
        if (!byId.isPresent()){
            return new ApiResponse("Bazda bunday idli ma'lumot topilmadi", false);
        }
        notebookRepository.deleteById(id);
        return new ApiResponse("Ma'lumotlar o'chirildi", true);
    }
}
