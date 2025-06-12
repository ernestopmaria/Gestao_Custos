package com.java_week.gestao_custos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java_week.gestao_custos.entity.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, java.util.UUID> {
    // Aqui você pode adicionar métodos personalizados de consulta, se necessário

}
