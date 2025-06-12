package com.java_week.gestao_custos.useCases;

import org.springframework.stereotype.Service;

import com.java_week.gestao_custos.entity.Despesa;
import com.java_week.gestao_custos.repository.DespesaRepository;

@Service
public class CadastroDespesasUseCase {

    private final DespesaRepository despesaRepository;

    public CadastroDespesasUseCase(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    public Despesa execute(Despesa despesa) {
        // Use despesaRepository to perform operations
        despesaRepository.save(despesa);
        return despesa;
    }

}
