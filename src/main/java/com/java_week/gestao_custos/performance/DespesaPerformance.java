package com.java_week.gestao_custos.performance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java_week.gestao_custos.entity.Despesa;
import com.java_week.gestao_custos.repository.DespesaRepository;

import org.springframework.cache.annotation.Cacheable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/javadevweek/performance/despesas")
@RestController
@EnableCaching
public class DespesaPerformance {

    @Autowired
    DespesaRepository despesaRepository;

    @GetMapping("/listar-sem-paginacao")
    public ResponseEntity<List<Despesa>> listarSemPaginacao() {
        long inicio = System.currentTimeMillis();
        System.out.println("Iniciando a listagem de despesas sem paginação...");
        var despesas = despesaRepository.findAll();
        long fim = System.currentTimeMillis();
        System.out.println("Listagem concluída em " + (fim - inicio) + " ms");
        return ResponseEntity.ok(despesas);
    }

    @GetMapping("/listar-com-paginacao")
    public ResponseEntity<Page<Despesa>> listarComPaginacao(
            Pageable pageable) {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Page<Despesa> despesasPage = despesaRepository.findAll(pageable);

        stopWatch.stop();
        System.out.println("Listagem concluída em " + stopWatch.getTotalTimeMillis() + " ms");

        return ResponseEntity.ok(despesasPage);
    }

    @GetMapping("/listar-com-paginacao/{email}")
    public ResponseEntity<Page<Despesa>> listarEmailComPaginacao(@PathVariable String email,
            Pageable pageable) {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Page<Despesa> despesasPage = despesaRepository.findByEmail(email, pageable);

        stopWatch.stop();
        System.out.println("Listagem concluída em " + stopWatch.getTotalTimeMillis() + " ms");

        return ResponseEntity.ok(despesasPage);
    }

    @Cacheable(value = "despesas", key = "#email + '-'+ #pageable.pageNumber + '-' + #pageable.pageSize + '-'")
    @GetMapping("/cache/{email}")
    public ResponseEntity<Page<Despesa>> listarComCache(@PathVariable String email,
            Pageable pageable) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Page<Despesa> despesas = despesaRepository.findByEmail(email, pageable);

        stopWatch.stop();
        System.out.println("Listagem com cache concluída em " + stopWatch.getTotalTimeMillis() + " ms");

        return ResponseEntity.ok(despesas);
    }

}
