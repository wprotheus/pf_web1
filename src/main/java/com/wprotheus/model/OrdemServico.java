package com.wprotheus.model;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.CarroDao;
import com.wprotheus.DAO.acessos.ClienteDao;
import com.wprotheus.DAO.acessos.OrdemServicoDao;
import com.wprotheus.utils.ValidaCampo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

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
    private List<OrdemServico> osServicos;
    private List<Servico> servicoList;

    public OrdemServico() {
    }

    public OrdemServico(int id, LocalDateTime dataEntrada, LocalDateTime dataSaida, String descServico, BigDecimal valorServico, BigDecimal valorTotal, Carro carro, Cliente cliente) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.descServico = descServico;
        this.valorServico = valorServico;
        this.valorTotal = valorTotal;
        this.carro = carro;
        this.cliente = cliente;
    }

    public OrdemServico(LocalDateTime dataEntrada, LocalDateTime dataSaida, String descServico, BigDecimal valorServico, BigDecimal valorTotal, Carro carro, Cliente cliente) {
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.descServico = descServico;
        this.valorServico = valorServico;
        this.valorTotal = valorTotal;
        this.carro = carro;
        this.cliente = cliente;
    }

    public BigDecimal getValorTotal() {
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (OrdemServico os : osServicos) {
            valorTotal = valorTotal.add(os.getValorServico());
        }
        return valorTotal;
    }
}