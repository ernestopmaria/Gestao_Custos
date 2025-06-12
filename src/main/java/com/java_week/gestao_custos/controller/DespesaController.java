package com.java_week.gestao_custos.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java_week.gestao_custos.dto.DespesaDTO;
import com.java_week.gestao_custos.entity.Despesa;
import com.java_week.gestao_custos.useCases.CadastroDespesasUseCase;
import com.java_week.gestao_custos.useCases.ListarDespesasUseCase;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/javadevweek")
@RestController
public class DespesaController {

    @Autowired
    CadastroDespesasUseCase cadastroDespesasUseCase;
    @Autowired
    ListarDespesasUseCase listarDespesasUseCase;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DespesaDTO despesa) {
        Despesa despesaEntity = new Despesa(
                despesa.getDescricao(),
                despesa.getValor(),
                despesa.getCategoria(),
                despesa.getData(),
                despesa.getEmail());

        cadastroDespesasUseCase.execute(despesaEntity);
        return ResponseEntity.ok("Despesa cadastrada com sucesso!");

    }

    @GetMapping
    public ResponseEntity<List<DespesaDTO>> list() {
        // Use the use case to retri
        List<DespesaDTO> despesas = listarDespesasUseCase.execute();
        return ResponseEntity.ok(despesas);
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<DespesaDTO>> findByEmail(@PathVariable String email,
            @RequestParam(required = false) LocalDate data) {
        // Use the use case to retrieve expenses by email

        List<DespesaDTO> despesas = listarDespesasUseCase.executeByEmail(email, data);
        return ResponseEntity.ok(despesas);
    }

}
