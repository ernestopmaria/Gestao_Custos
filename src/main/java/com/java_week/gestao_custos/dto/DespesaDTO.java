package com.java_week.gestao_custos.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.java_week.gestao_custos.entity.Despesa;

public class DespesaDTO {
    private UUID id;
    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;
    @NotNull(message = "Data é obrigatória")
    private LocalDate data; // data formatada
    @NotNull(message = "Valor é obrigatório")
    private double valor;

    @NotBlank(message = "Categoria é obrigatória")
    private String categoria;
    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
    private String email;
    private String dataCriacao; // data/hora formatada

    public DespesaDTO() {
    }

    public DespesaDTO(Despesa despesa) {
        this.id = despesa.getId();
        this.descricao = despesa.getDescricao();
        this.data = despesa.getData();
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

    public LocalDate getData() {
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
