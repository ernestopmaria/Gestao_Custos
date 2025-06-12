package com.java_week.gestao_custos.useCases;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java_week.gestao_custos.dto.DespesaDTO;

import com.java_week.gestao_custos.repository.DespesaRepository;

@Service
public class ListarDespesasUseCase {

    private final DespesaRepository despesaRepository;

    public ListarDespesasUseCase(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    public List<DespesaDTO> execute() {
        // Use despesaRepository to retrieve all expenses
        return despesaRepository.findAll().stream()
                .map(DespesaDTO::new) // Convert each Despesa to DespesaDTO
                .toList(); // Collect the results into a List
    }

}
