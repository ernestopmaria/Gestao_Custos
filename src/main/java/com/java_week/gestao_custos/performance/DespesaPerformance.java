package com.java_week.gestao_custos.performance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java_week.gestao_custos.entity.Despesa;
import com.java_week.gestao_custos.repository.DespesaRepository;
import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("/javadevweek/performance/despesas")
@RestController
public class DespesaPerformance {

    @Autowired
    DespesaRepository despesaRepository;

    @GetMapping("/listar-com-paginacao")
    public ResponseEntity<List<Despesa>> listarSemPaginacao() {
        long inicio = System.currentTimeMillis();
        System.out.println("Iniciando a listagem de despesas sem paginação...");
        var despesas = despesaRepository.findAll();
        long fim = System.currentTimeMillis();
        System.out.println("Listagem concluída em " + (fim - inicio) + " ms");
        return ResponseEntity.ok(despesas);
    }

}
