package com.example.pcmarket.service;

import com.example.pcmarket.entity.Categoriya;
import com.example.pcmarket.payload.ApiResponse;
import com.example.pcmarket.repository.CategoriyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriyaService {
    @Autowired
    CategoriyaRepository categoriyaRepository;

    public ApiResponse addCategoriya(Categoriya categoriya) {
        boolean b = categoriyaRepository.existsByNomi(categoriya.getNomi());
        if (b){
            return new ApiResponse("Bazda bunday nomdagi categoriya mavjud", false);
        }
        categoriyaRepository.save(categoriya);
        return new ApiResponse("Ma'lumotlar muvoffaqiyatli saqlandi", true);
    }

    public ApiResponse editCategoriya(Integer id, Categoriya categoriya) {
        Optional<Categoriya> byId = categoriyaRepository.findById(id);
        if (!byId.isPresent()){
            return new ApiResponse("Bazada bunday idli categoriya mavjud emas", false);
        }
        Categoriya categoriya1=byId.get();
        categoriya1.setNomi(categoriya.getNomi());
        categoriyaRepository.save(categoriya1);
        return new ApiResponse("Ma'lumotlar tahrirlandi", true);
    }

    public ApiResponse getCategoriya() {
        List<Categoriya> list=categoriyaRepository.findAll();
        return new ApiResponse(list.toString(), true);
    }

    public ApiResponse getIdCategoriya(Integer id) {
        List<Categoriya> list=categoriyaRepository.findAll();
        for (Categoriya categoriya : list) {
            if (categoriya.getId().equals(id)){
                return new ApiResponse(categoriya.toString(), true);
            }
        }
        return new ApiResponse("Bazda bunday idli ma'lumot topilmadi",false);
    }

    public ApiResponse deleteCategoriya(Integer id) {
        Optional<Categoriya> byId = categoriyaRepository.findById(id);
        if (!byId.isPresent()){
            return new ApiResponse("Bazda bunday idli ma'lumot topilmadi", false);
        }
        categoriyaRepository.deleteById(id);
        return new ApiResponse("Ma'lumotlar o'chirildi", true);
    }
}
