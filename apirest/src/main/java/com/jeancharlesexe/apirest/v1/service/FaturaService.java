package com.jeancharlesexe.apirest.v1.service;

import com.jeancharlesexe.apirest.v1.model.Fatura;
import com.jeancharlesexe.apirest.v1.repository.FaturaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaturaService {
    @Autowired
    private FaturaRepository faturaRepository;

    public List<Fatura> findAll() {
        List<Fatura> faturas = faturaRepository.findAll();

        if(faturas.isEmpty()){
            throw new EntityNotFoundException("Faturas não encontradas");
        }

        try{
            return faturas;
        }catch(Exception e){
            throw new RuntimeException("Ocorreu um erro ao buscar faturas: " + e.getMessage());
        }
    }

    public Fatura save(Fatura fatura) {
        try{
            return faturaRepository.save(fatura);
        }catch(Exception e){
            throw new RuntimeException("Ocorreu um erro ao salvar fatura: " + e.getMessage());
        }
    }
}
