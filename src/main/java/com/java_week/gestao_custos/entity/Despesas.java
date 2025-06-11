package com.java_week.gestao_custos.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "despesas")
public class Despesas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String descricao;
    private LocalDate data;
    private double valor;
    private String categoria;
    private String email;

    @CreatedDate
    private LocalDate data_criacao;




    public Despesas(String descricao, double valor, String categoria, LocalDate data, String email) {
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.data = data;
        this.email = email;
    }


    public UUID getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCriacao() {
        return data_criacao;
    }
}