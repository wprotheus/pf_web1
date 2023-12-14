package com.wprotheus.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Servico implements Serializable {
    private int id;
    private String nome;
    private String descricao;
    private BigDecimal valor;

    public Servico() {
    }

    public Servico(int id, String nome, String descricao, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Servico(String nome, String descricao, BigDecimal valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }
}