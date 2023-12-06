package com.wprotheus.DAO.acessos;

import com.wprotheus.DAO.ConexaoDB;
import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.interfaces.OrdemServicoDaoInterface;
import com.wprotheus.model.Cliente;
import com.wprotheus.model.OrdemServico;
import com.wprotheus.utils.StatementPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OrdemServicoDao implements OrdemServicoDaoInterface {
    private Connection connection;

    public OrdemServicoDao() throws ErroDAO {
        connection = ConexaoDB.fazerConexao();
    }

    @Override
    public void cadastrar(OrdemServico ordemServico) throws ErroDAO {
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("insert into pf_web1.tb_os " +
                            "(data_entrada, data_saida, desc_servico, valor_servico, valor_total, tb_carro_id, tb_cliente_id) " +
                            "values (?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            StatementPool.psOrdemServico(ordemServico, statement);

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
                ordemServico.setId(resultSet.getInt(1));
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
                ordemServicoSet.add(os);
            }
            return ordemServicoSet;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public OrdemServico buscarId() throws ErroDAO {
        try {
            Cliente c = new Cliente();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from pf_web1.tb_os");
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
}