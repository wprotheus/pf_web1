package com.wprotheus.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Cliente implements Serializable {
    private int id;
    private String nome;
    private String endereco;
    private String telefone;

    public Cliente() {
    }

    public Cliente(int id, String nome, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Cliente(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
}