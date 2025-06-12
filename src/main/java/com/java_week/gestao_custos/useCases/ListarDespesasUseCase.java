package com.java_week.gestao_custos.useCases;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_week.gestao_custos.dto.DespesaDTO;

import com.java_week.gestao_custos.repository.DespesaRepository;

@Service
public class ListarDespesasUseCase {

    @Autowired
    private DespesaRepository despesaRepository;

    public List<DespesaDTO> execute() {
        // Use despesaRepository to retrieve all expenses
        return despesaRepository.findAll().stream()
                .map(DespesaDTO::new) // Convert each Despesa to DespesaDTO
                .toList(); // Collect the results into a List
    }

    public List<DespesaDTO> executeByEmail(String email, LocalDate data) {
        // Use despesaRepository to retrieve expenses by email
        List<DespesaDTO> despesas;

        if (data != null) {
            despesas = despesaRepository.findByEmailAndData(email, data).stream()
                    .map(despesa -> new DespesaDTO(despesa)) // Convert Despesa to DespesaDTO
                    .toList(); // Collect the results into a List
        } else {
            despesas = despesaRepository.findByEmail(email).stream()
                    .map(DespesaDTO::new) // Convert Despesa to DespesaDTO
                    .toList(); // Collect the results into a List

        }
        return despesas;
    }

}
