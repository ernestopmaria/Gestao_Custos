package com.java_week.gestao_custos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java_week.gestao_custos.dto.DespesaDTO;
import com.java_week.gestao_custos.entity.Despesa;
import com.java_week.gestao_custos.useCases.CadastroDespesasUseCase;
import com.java_week.gestao_custos.useCases.ListarDespesasUseCase;

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
    public Despesa create(@RequestBody Despesa entity) {
        return cadastroDespesasUseCase.execute(entity);

    }

    @GetMapping
    public ResponseEntity<List<DespesaDTO>> list() {
        // Use the use case to retri
        List<DespesaDTO> despesas = listarDespesasUseCase.execute();
        return ResponseEntity.ok(despesas);
    }

}
