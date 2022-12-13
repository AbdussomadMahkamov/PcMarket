package com.example.pcmarket.service;

import com.example.pcmarket.entity.Categoriya;
import com.example.pcmarket.entity.Mahsulot;
import com.example.pcmarket.payload.ApiResponse;
import com.example.pcmarket.payload.NotebookDto;
import com.example.pcmarket.repository.CategoriyaRepository;
import com.example.pcmarket.repository.MahsulotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MahsulotService {
    @Autowired
    MahsulotRepository mahsulotRepository;
    @Autowired
    CategoriyaRepository categoriyaRepository;

    public ApiResponse addNotebook(NotebookDto dto) {
        Optional<Categoriya> byId = categoriyaRepository.findById(dto.getCategoriyaId());
        if (!byId.isPresent()){
            return new ApiResponse("Bunday idda categoriya mavjud emas", false);
        }
        boolean b = mahsulotRepository.existsByVideokartaAndEkranDioganalAndEkranOlchamAndProtsessorAndRamAndQattiqDiskAndSistemaAndCategoriya(dto.getVideokarta(), dto.getEkranDioganal(), dto.getEkranOlcham(), dto.getProtsessor(), dto.getRam(), dto.getQattiqDisk(), dto.getSistema(), byId.get());
        if (b){
            return new ApiResponse("Bazda bunday ma'lumot oldin saqlangan", false);
        }
        Mahsulot mahsulot=new Mahsulot();
        mahsulot.setVideokarta(dto.getVideokarta());
        mahsulot.setEkranDioganal(dto.getEkranDioganal());
        mahsulot.setEkranOlcham(dto.getEkranOlcham());
        mahsulot.setProtsessor(dto.getProtsessor());
        mahsulot.setRam(dto.getRam());
        mahsulot.setQattiqDisk(dto.getQattiqDisk());
        mahsulot.setSistema(dto.getSistema());
        mahsulot.setCategoriya(byId.get());
        mahsulotRepository.save(mahsulot);
        return new ApiResponse("Ma'lumotlar bazaga saqlandi", true);
    }

    public ApiResponse getidNotebook(Integer id) {
        Optional<Mahsulot> byId = mahsulotRepository.findById(id);
        if (!byId.isPresent()){
            return new ApiResponse("Bazda bunday idli ma'lumot mavjud emas", false);
        }
        String S="";
        List<Mahsulot> list = mahsulotRepository.findAll();
        for (Mahsulot mahsulot : list) {
            if (mahsulot.getId().equals(id)){
                S=
                        "Categoiya: "+mahsulot.getCategoriya().getNomi()+"\n"+
                        "Videokarta: "+mahsulot.getVideokarta().toString()+"\n"+
                        "Ekran dioganali: "+mahsulot.getEkranDioganal().toString()+"\n"+
                        "Ekran o'lchami: "+mahsulot.getEkranOlcham().toString()+"\n"+
                        "Protsessor: "+mahsulot.getProtsessor().toString()+"\n"+
                        "Operativ xotira(RAM): "+mahsulot.getRam().toString()+"\n"+
                        "Qattiq disk: "+mahsulot.getQattiqDisk().toString()+"\n"+
                        "Operatsion sistema: "+mahsulot.getSistema().toString();
            }
        }

        return new ApiResponse(S, true);
    }

    public ApiResponse getNotebook() {
        String S="";
        List<Mahsulot> list = mahsulotRepository.findAll();
        for (Mahsulot mahsulot : list) {
            S+=
                    "Categoiya: "+mahsulot.getCategoriya().getNomi()+"\n"+
                    "Videokarta: "+mahsulot.getVideokarta().toString()+"\n"+
                    "Ekran dioganali: "+mahsulot.getEkranDioganal().toString()+"\n"+
                    "Ekran o'lchami: "+mahsulot.getEkranOlcham().toString()+"\n"+
                    "Protsessor: "+mahsulot.getProtsessor().toString()+"\n"+
                    "Operativ xotira(RAM): "+mahsulot.getRam().toString()+"\n"+
                    "Qattiq disk: "+mahsulot.getQattiqDisk().toString()+"\n"+
                    "Operatsion sistema: "+mahsulot.getSistema().toString()+"\n\n";
        }
        return new ApiResponse(S, true);
    }

    public ApiResponse deleteNotebook(Integer id) {
        Optional<Mahsulot> byId = mahsulotRepository.findById(id);
        if (!byId.isPresent()){
            return new ApiResponse("Bazada bunday id li ma'lumot topilmadi", false);
        }
        mahsulotRepository.deleteById(id);
        return new ApiResponse("Bazadan ma'lumot o'chirildi", true);
    }

    public ApiResponse editNotebook(Integer id, NotebookDto dto) {
        Optional<Mahsulot> byId = mahsulotRepository.findById(id);
        if (!byId.isPresent()){
            return new ApiResponse("Bazada bunday idli ma'lumot mavjud emas!", false);
        }
        Optional<Categoriya> byId1 = categoriyaRepository.findById(dto.getCategoriyaId());
        if (!byId1.isPresent()){
            return new ApiResponse("Bazada bunday idli categoriya mavjud emas!", false);
        }
        Mahsulot mahsulot=byId.get();
        mahsulot.setVideokarta(dto.getVideokarta());
        mahsulot.setEkranDioganal(dto.getEkranDioganal());
        mahsulot.setEkranOlcham(dto.getEkranOlcham());
        mahsulot.setProtsessor(dto.getProtsessor());
        mahsulot.setRam(dto.getRam());
        mahsulot.setQattiqDisk(dto.getQattiqDisk());
        mahsulot.setSistema(dto.getSistema());
        mahsulot.setCategoriya(byId1.get());
        mahsulotRepository.save(mahsulot);
        return new ApiResponse("Ma'lumotlar tahrirlandi", true);
    }
}
