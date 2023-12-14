package com.wprotheus.model;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.CarroDao;
import com.wprotheus.DAO.acessos.ClienteDao;
import lombok.Data;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class ServicoOrdemServico implements Serializable {
    private Servico servico;
    private OrdemServico ordemServico;

    public ServicoOrdemServico() {
    }

    public ServicoOrdemServico(Servico servico, OrdemServico ordemServico) {
        this.servico = servico;
        this.ordemServico = ordemServico;
    }

    public OrdemServico criarOrdemServico(ResultSet resultSet) throws SQLException, ErroDAO {
        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setId(resultSet.getInt("id"));
        ordemServico.setDataEntrada(resultSet.getDate("data_entrada").toLocalDate().atStartOfDay());
        ordemServico.setDataSaida(resultSet.getDate("data_saida") != null ? resultSet.getDate("data_saida").toLocalDate().atStartOfDay() : null);
        ordemServico.setDescServico(resultSet.getString("desc_servico"));
        ordemServico.setValorServico(resultSet.getBigDecimal("valor_servico"));
        ordemServico.setValorTotal(resultSet.getBigDecimal("valor_total"));

        int idCarro = resultSet.getInt("tb_carro_id");
        int idCliente = resultSet.getInt("tb_cliente_id");

        CarroDao carroDao = new CarroDao();
        ClienteDao clienteDao = new ClienteDao();
        Carro carro = carroDao.buscarId(idCarro);
        Cliente cliente = clienteDao.buscarId(idCliente);
        ordemServico.setCarro(carro);
        ordemServico.setCliente(cliente);

        return ordemServico;
    }
}
