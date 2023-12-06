package com.wprotheus.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Carro implements Serializable
{
    private int id;
    private String modelo;
    private String marca;
    private String ano;
    private String placa;

    public Carro() {
    }

    public Carro(int id, String modelo, String marca, String ano, String placa) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.placa = placa;
    }

    public Carro(String modelo, String marca, String ano, String placa) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.placa = placa;
    }
}