package com.wprotheus.DAO.acessos;

import com.wprotheus.DAO.ConexaoDB;
import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.interfaces.FuncionarioDaoInterface;
import com.wprotheus.model.Funcionario;
import com.wprotheus.utils.StatementPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class FuncionarioDao implements FuncionarioDaoInterface {
    private Connection connection;

    public FuncionarioDao() throws ErroDAO {
        connection = ConexaoDB.fazerConexao();
    }

    @Override
    public void cadastrar(Funcionario funcionario) throws ErroDAO {
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("insert into pf_web1.tb_funcionario (nome, login, senha) values (?, ?, ?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);
            StatementPool.psFuncionario(funcionario, statement);
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
                funcionario.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public Set<Funcionario> buscar() throws ErroDAO {
        try {
            Set<Funcionario> funcionarioSet = new HashSet<>();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from pf_web1.tb_funcionario");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                funcionarioSet.add(StatementPool.getFuncionario(resultSet));
            }
            return funcionarioSet;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public Funcionario buscar(String login, String senha) throws ErroDAO {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from pf_web1.tb_funcionario where login=? and senha=?");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return StatementPool.getFuncionario(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void atualizar(Funcionario funcionario) throws ErroDAO {
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("update pf_web1.tb_funcionario set nome=?, login=?, senha=? where id=?");
            StatementPool.psFuncionario(funcionario, statement);
            statement.setInt(4, funcionario.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void deletar(int idFunc) throws ErroDAO {
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("delete from pf_web1.tb_funcionario where id=?");
            statement.setInt(1, idFunc);
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