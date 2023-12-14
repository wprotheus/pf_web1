package com.wprotheus.DAO.acessos;

import com.wprotheus.DAO.ConexaoDB;
import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.interfaces.OrdemServicoDaoInterface;
import com.wprotheus.model.Carro;
import com.wprotheus.model.Cliente;
import com.wprotheus.model.OrdemServico;
import com.wprotheus.model.Servico;
import com.wprotheus.utils.StatementPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrdemServicoDao implements OrdemServicoDaoInterface {
    private Connection connection;

    public OrdemServicoDao() throws ErroDAO {
        connection = ConexaoDB.fazerConexao();
    }

    @Override
    public void cadastrar(OrdemServico ordemServico) throws ErroDAO {
        try {
            PreparedStatement statementOs = connection.prepareStatement(
                    "INSERT INTO pf_web1.tb_os " +
                            "(data_entrada, data_saida, desc_servico, valor_servico, valor_total, tb_carro_id, tb_cliente_id) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );
            StatementPool.psOrdemServico(ordemServico, statementOs);
            statementOs.executeUpdate();

            ResultSet resultSet = statementOs.getGeneratedKeys();
            int tbOsId = -1;
            if (resultSet.next()) {
                tbOsId = resultSet.getInt(1);
                ordemServico.setId(tbOsId);
            }


        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public Set<OrdemServico> buscar() throws ErroDAO {
        try {
            Set<OrdemServico> ordemServicoSet = new HashSet<>();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from pf_web1.tb_os");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                OrdemServico os = StatementPool.getOrdemServico(resultSet);
                PreparedStatement psServicos = connection.prepareStatement
                        ("select * from pf_web1.tb_servico_has_tb_os where tb_os_id = ?");
                psServicos.setInt(1, os.getId());
                ResultSet rsServicos = psServicos.executeQuery();
                List<Servico> servicos = new ArrayList<>();
                while (rsServicos.next()) {
                    Servico s = StatementPool.getServico(rsServicos);
                    servicos.add(s);
                }
                os.setServicoList(servicos);
                ordemServicoSet.add(os);
            }
            return ordemServicoSet;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }


    @Override
    public OrdemServico buscarId(int idOS) throws ErroDAO {
        try {
            Cliente c = new Cliente();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from pf_web1.tb_os where id=?");
            preparedStatement.setInt(1, idOS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return StatementPool.getOrdemServico(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void atualizar(OrdemServico ordemServico) throws ErroDAO {
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("update pf_web1.tb_os set data_entrada=?, data_saida=?, desc_servico=?, valor_servico=?, valor_total=?, " +
                            "tb_carro_id=?, tb_cliente_id=? where id=?");
            StatementPool.psOrdemServico(ordemServico, statement);
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void deletar(int idOS) throws ErroDAO {
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("delete from pf_web1.tb_os where id=?");
            statement.setInt(1, idOS);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void close() throws ErroDAO {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
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