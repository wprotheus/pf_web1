package com.wprotheus.DAO.acessos;

import com.wprotheus.DAO.interfaces.CarroDaoInterface;
import com.wprotheus.DAO.ConexaoDB;
import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.model.Carro;
import com.wprotheus.utils.StatementPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CarroDao implements CarroDaoInterface {
    private Connection connection;

    public CarroDao() throws ErroDAO {
        connection = ConexaoDB.fazerConexao();
    }

    @Override
    public void cadastrar(Carro carro) throws ErroDAO {
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("insert into pf_web1.tb_carro (modelo, marca, ano, placa) values (?, ?, ?, ?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);
            StatementPool.psCarro(carro, statement);
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
                carro.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public Set<Carro> buscar() throws ErroDAO {
        try {
            Set<Carro> carroSet = new HashSet<>();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from pf_web1.tb_carro");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Carro c = StatementPool.getCarro(resultSet);
                carroSet.add(c);
            }
            return carroSet;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public Carro buscarId() throws ErroDAO {
        try {
            Carro c = new Carro();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from pf_web1.tb_carro");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return StatementPool.getCarro(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void atualizar(Carro carro) throws ErroDAO {
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("update pf_web1.tb_carro set modelo=?, marca=?, ano=?, placa=? where id=?");
            StatementPool.psCarro(carro, statement);
            statement.setInt(5, carro.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new ErroDAO(e);
        }
    }

    @Override
    public void deletar(int idCarro) throws ErroDAO {
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("delete from pf_web1.tb_carro where id=?");
            statement.setInt(1, idCarro);
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