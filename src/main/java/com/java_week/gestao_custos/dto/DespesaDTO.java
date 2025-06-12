package com.java_week.gestao_custos.dto;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.java_week.gestao_custos.entity.Despesa;

public class DespesaDTO {
    private UUID id;
    private String descricao;
    private String data; // data formatada
    private double valor;
    private String categoria;
    private String email;
    private String dataCriacao; // data/hora formatada

    public DespesaDTO(Despesa despesa) {
        this.id = despesa.getId();
        this.descricao = despesa.getDescricao();
        this.data = despesa.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.valor = despesa.getValor();
        this.categoria = despesa.getCategoria();
        this.email = despesa.getEmail();
        this.dataCriacao = despesa.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    // Getters

    public UUID getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEmail() {
        return email;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }
}
