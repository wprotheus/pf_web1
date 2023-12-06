package com.wprotheus.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Funcionario implements Serializable {
    private int id;
    private String nome;
    private String login;
    private String senha;

    public Funcionario() {
    }

    public Funcionario(int id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Funcionario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
}