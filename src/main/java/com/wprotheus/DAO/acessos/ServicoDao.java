package com.wprotheus.DAO.acessos;

import com.wprotheus.DAO.ConexaoDB;
import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.interfaces.ServicoDaoInterface;
import com.wprotheus.model.Servico;
import com.wprotheus.utils.StatementPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ServicoDao implements ServicoDaoInterface {
    private Connection connection;

    public ServicoDao() throws ErroDAO {
        connection = ConexaoDB.fazerConexao();
    }

    @Override
    public void cadastrar(Servico servico) throws ErroDAO {
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("insert into pf_web1.tb_servico (nome, descricao, valor) values (?, ?, ?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);
            StatementPool.psServico(servico, statement);
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
                servico.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public Set<Servico> buscar() throws ErroDAO {
        try {
            Set<Servico> servicoSet = new HashSet<>();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from pf_web1.tb_servico");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Servico s = StatementPool.getServico(resultSet);
                servicoSet.add(s);
            }
            return servicoSet;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public Servico buscarId() throws ErroDAO {
        try {
            Servico s = new Servico();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from pf_web1.tb_servico");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return StatementPool.getServico(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void atualizar(Servico servico) throws ErroDAO {
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("update pf_web1.tb_servico set nome=?, descricao=?, valor=? where id=?");
            StatementPool.psServico(servico, statement);
            statement.setInt(4, servico.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void deletar(int idSer) throws ErroDAO {
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