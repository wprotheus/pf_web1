package com.wprotheus.DAO.acessos;

import com.wprotheus.DAO.interfaces.ClienteDaoInterface;
import com.wprotheus.DAO.ConexaoDB;
import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.model.Cliente;
import com.wprotheus.utils.StatementPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ClienteDao implements ClienteDaoInterface {
    private Connection connection;

    public ClienteDao() throws ErroDAO {
        connection = ConexaoDB.fazerConexao();
    }

    @Override
    public void cadastrar(Cliente cliente) throws ErroDAO {
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("insert into pf_web1.tb_cliente (nome, endereco, telefone) values (?, ?, ?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);
            StatementPool.psCliente(cliente, statement);
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
                cliente.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public Set<Cliente> buscar() throws ErroDAO {
        try {
            Set<Cliente> clienteSet = new HashSet<>();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from pf_web1.tb_cliente");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cliente c = StatementPool.getCliente(resultSet);
                clienteSet.add(c);
            }
            return clienteSet;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public Cliente buscarId() throws ErroDAO {
        try {
            Cliente c = new Cliente();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from pf_web1.tb_cliente");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return StatementPool.getCliente(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void atualizar(Cliente cliente) throws ErroDAO {
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("update pf_web1.tb_cliente set nome=?, endereco=?, telefone=? where id=?");
            StatementPool.psCliente(cliente, statement);
            statement.setInt(4, cliente.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void deletar(int idCliente) throws ErroDAO {
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("delete from pf_web1.tb_cliente where id=?");
            statement.setInt(1, idCliente);
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