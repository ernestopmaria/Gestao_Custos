package com.java_week.gestao_custos.performance;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.java_week.gestao_custos.entity.Despesa;
import com.java_week.gestao_custos.repository.DespesaRepository;

//@Component
public class DespesasSeeder implements CommandLineRunner {

    @Autowired
    private DespesaRepository despesaRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Iniciando o seeding de despesas...");
        for (int i = 0; i < 15000; i++) {
            despesaRepository.save(new Despesa("Despesa " + i, Math.random() * 1000, "Categoria " + (i % 5),
                    LocalDate.now(), "email" + i + "@example.com"));
        }
        System.out.println("Despesas seedadas com sucesso!");
    }

}
