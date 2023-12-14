package com.wprotheus.DAO.acessos;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.interfaces.ServicoOrdemServicoDaoInterface;
import com.wprotheus.model.Carro;
import com.wprotheus.model.Cliente;
import com.wprotheus.model.OrdemServico;
import com.wprotheus.model.Servico;
import com.wprotheus.utils.StatementPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ServicoOrdemServicoDao implements ServicoOrdemServicoDaoInterface {

    private Connection connection;
    private StatementPool statementPool;

    public ServicoOrdemServicoDao(Connection connection, StatementPool statementPool) {
        this.connection = connection;
        this.statementPool = statementPool;
    }

    @Override
    public void relacionarServicoOS(Servico servico, OrdemServico ordemServico) throws ErroDAO {
        try {
            if (!temRelacionamento(servico.getId(), ordemServico.getId())) {
                PreparedStatement statement = connection.prepareStatement
                        ("INSERT INTO pf_web1.tb_servico_has_tb_os (tb_servico_id, tb_os_id) VALUES (?, ?)");
                statement.setInt(1, servico.getId());
                statement.setInt(2, ordemServico.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    private boolean temRelacionamento(int idServico, int idOrdemServico) throws SQLException {
        PreparedStatement statement = connection.prepareStatement
                ("SELECT * FROM pf_web1.tb_servico_has_tb_os WHERE tb_servico_id = ? AND tb_os_id = ?");
        statement.setInt(1, idServico);
        statement.setInt(2, idOrdemServico);
        ResultSet resultSet = statement.executeQuery();
        boolean result = resultSet.next();
        return result;
    }

    @Override
    public Set<Servico> listarServicosOS(OrdemServico ordemServico) throws ErroDAO {
        try {
            Set<Servico> servicos = new HashSet<>();
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT s.* FROM pf_web1.tb_servico s " +
                            "JOIN pf_web1.tb_servico_has_tb_os stos ON s.id = stos.tb_servico_id WHERE stos.tb_os_id = ?");
            statement.setInt(1, ordemServico.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Servico servico = new Servico();
                servico.setId(resultSet.getInt("id"));
                servico.setNome(resultSet.getString("nome"));
                servico.setDescricao(resultSet.getString("descricao"));
                servico.setValor(resultSet.getBigDecimal("valor"));
                servicos.add(servico);
            }
            return servicos;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public Set<OrdemServico> listarOSCliente(Cliente cliente) throws ErroDAO {
        try {
            Set<OrdemServico> ordemServicoSet = new HashSet<>();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT os.* FROM pf_web1.tb_os os " +
                            "JOIN pf_web1.tb_cliente c ON os.tb_cliente_id = c.id WHERE c.id = ?");
            statement.setInt(1, cliente.getId());
            ResultSet resultSet = statement.executeQuery();

            OrdemServicoDao ordemServicoDao = new OrdemServicoDao();
            while (resultSet.next()) {
                OrdemServico ordemServico = ordemServicoDao.criarOrdemServico(resultSet);
                ordemServicoSet.add(ordemServico);
            }
            return ordemServicoSet;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public Set<OrdemServico> listarOSCarro(Carro carro) throws ErroDAO {
        try {
            Set<OrdemServico> ordensServico = new HashSet<>();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT os.* FROM pf_web1.tb_os os " +
                            "JOIN pf_web1.tb_carro c ON os.tb_carro_id = c.id WHERE c.id = ?");
            statement.setInt(1, carro.getId());
            ResultSet resultSet = statement.executeQuery();

            OrdemServicoDao ordemServicoDao = new OrdemServicoDao();
            while (resultSet.next()) {
                OrdemServico ordemServico = ordemServicoDao.criarOrdemServico(resultSet);
                ordensServico.add(ordemServico);
            }
            return ordensServico;
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
}
