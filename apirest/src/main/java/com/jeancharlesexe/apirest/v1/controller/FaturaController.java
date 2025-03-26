package com.jeancharlesexe.apirest.v1.controller;

import com.jeancharlesexe.apirest.v1.model.Fatura;
import com.jeancharlesexe.apirest.v1.service.FaturaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/faturas")
public class FaturaController {
    @Autowired
    private FaturaService faturaService;

    @GetMapping
    public ResponseEntity<?> fatura() {
        try{
            List<Fatura> faturasEncontrada = faturaService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(faturasEncontrada);
        }catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addFatura(@RequestBody @Valid Fatura fatura) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(faturaService.save(fatura));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
}
