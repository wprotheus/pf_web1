package com.wprotheus.utils;

import com.wprotheus.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StatementPool {

    public static void psCarro(Carro carro, PreparedStatement statement) throws SQLException {
        statement.setString(1, carro.getModelo());
        statement.setString(2, carro.getMarca());
        statement.setString(3, carro.getAno());
        statement.setString(4, carro.getPlaca());
    }

    public static Carro getCarro(ResultSet resultSet) throws SQLException {
        Carro c = new Carro();
        c.setId(resultSet.getInt("id"));
        c.setModelo(resultSet.getString("modelo"));
        c.setMarca(resultSet.getString("marca"));
        c.setAno(resultSet.getString("ano"));
        c.setPlaca(resultSet.getString("placa"));
        return c;
    }

    public static void psCliente(Cliente cliente, PreparedStatement statement) throws SQLException {
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getEndereco());
        statement.setString(3, cliente.getTelefone());
    }

    public static Cliente getCliente(ResultSet resultSet) throws SQLException {
        Cliente c = new Cliente();
        c.setId(resultSet.getInt("id"));
        c.setNome(resultSet.getString("nome"));
        c.setEndereco(resultSet.getString("endereco"));
        c.setTelefone(resultSet.getString("telefone"));
        return c;
    }

    public static void psFuncionario(Funcionario funcionario, PreparedStatement statement) throws SQLException {
        statement.setString(1, funcionario.getNome());
        statement.setString(2, funcionario.getLogin());
        statement.setString(3, funcionario.getSenha());
    }

    public static Funcionario getFuncionario(ResultSet resultSet) throws SQLException {
        Funcionario f = new Funcionario();
        f.setId(resultSet.getInt("id"));
        f.setNome(resultSet.getString("nome"));
        f.setLogin(resultSet.getString("login"));
        f.setSenha(resultSet.getString("senha"));
        return f;
    }

    public static void psOrdemServico(OrdemServico ordemServico, PreparedStatement statement) throws SQLException {
        statement.setTimestamp(1, Timestamp.valueOf(ordemServico.getDataEntrada()));
        statement.setTimestamp(2, Timestamp.valueOf(ordemServico.getDataSaida()));
        statement.setString(3, ordemServico.getDescServico());
        statement.setBigDecimal(4, ordemServico.getValorServico());
        statement.setBigDecimal(5, ordemServico.getValorTotal());
        statement.setInt(6, ordemServico.getCarro().getId());
        statement.setInt(7, ordemServico.getCliente().getId());
        statement.executeUpdate();
    }

    public static OrdemServico getOrdemServico(ResultSet resultSet) throws SQLException {
        OrdemServico os = new OrdemServico();
        os.setId(resultSet.getInt("id"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Timestamp dataEntrada = resultSet.getTimestamp("data_entrada");
        Timestamp dataSaida = resultSet.getTimestamp("2000-01-01");

        os.setDataEntrada(dataEntrada.toLocalDateTime());
        os.setDataSaida(dataSaida.toLocalDateTime());
        os.setDescServico(resultSet.getString("desc_servico"));
        os.setValorServico(resultSet.getBigDecimal("valor_servico"));
        os.setValorTotal(resultSet.getBigDecimal("valor_total"));
        os.getCarro().setId(resultSet.getInt("tb_carro_id"));
        os.getCliente().setId(resultSet.getInt("tb_cliente_id"));
        return os;
    }

    public static void psServico(Servico servico, PreparedStatement statement) throws SQLException {
        statement.setString(1, servico.getNome());
        statement.setString(2, servico.getDescricao());
        statement.setBigDecimal(3, servico.getValor());
    }

    public static Servico getServico(ResultSet resultSet) throws SQLException {
        Servico s = new Servico();
        s.setId(resultSet.getInt("id"));
        s.setNome(resultSet.getString("nome"));
        s.setDescricao(resultSet.getString("descricao"));
        s.setValor(resultSet.getBigDecimal("valor"));
        return s;
    }
}