package com.java_week.gestao_custos.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java_week.gestao_custos.entity.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, java.util.UUID> {

    List<Despesa> findByEmail(String email);

    List<Despesa> findByEmailAndData(String email, java.time.LocalDate data);

    Page<Despesa> findByEmail(String email, Pageable pageable);

}
