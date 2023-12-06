package com.wprotheus.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrdemServico implements Serializable {
    private int id;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private String descServico;
    private BigDecimal valorServico;
    private BigDecimal valorTotal;
    private Carro carro;
    private Cliente cliente;
    private Servico servico;

    public OrdemServico() {
    }

    public OrdemServico(int id, LocalDateTime dataEntrada, LocalDateTime dataSaida, String descServico, BigDecimal valorServico, BigDecimal valorTotal, Carro carro, Cliente cliente, Servico servico) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.descServico = descServico;
        this.valorServico = valorServico;
        this.valorTotal = valorTotal;
        this.carro = carro;
        this.cliente = cliente;
        this.servico = servico;
    }

    public OrdemServico(LocalDateTime dataEntrada, LocalDateTime dataSaida, String descServico, BigDecimal valorServico, BigDecimal valorTotal, Carro carro, Cliente cliente, Servico servico) {
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.descServico = descServico;
        this.valorServico = valorServico;
        this.valorTotal = valorTotal;
        this.carro = carro;
        this.cliente = cliente;
        this.servico = servico;
    }
}