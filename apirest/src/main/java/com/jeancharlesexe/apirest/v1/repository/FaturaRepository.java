package com.jeancharlesexe.apirest.v1.repository;

import com.jeancharlesexe.apirest.v1.model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Integer> { }
