package com.wprotheus.utils;

import com.wprotheus.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

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
        c.setModelo(resultSet.getString("marca"));
        c.setModelo(resultSet.getString("ano"));
        c.setModelo(resultSet.getString("placa"));
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
        statement.setString(1, String.valueOf(ordemServico.getDataEntrada()));
        statement.setString(2, String.valueOf(ordemServico.getDataSaida()));
        statement.setString(3, ordemServico.getDescServico());
        statement.setString(4, String.valueOf(ordemServico.getValorServico()));
        statement.setString(5, String.valueOf(ordemServico.getValorTotal()));
        statement.setString(6, String.valueOf(ordemServico.getCarro().getId()));
        statement.setString(7, String.valueOf(ordemServico.getCliente().getId()));
        statement.executeUpdate();
    }

    public static OrdemServico getOrdemServico(ResultSet resultSet) throws SQLException {
        OrdemServico os = new OrdemServico();
        os.setId(resultSet.getInt("id"));
        os.setDataEntrada(LocalDateTime.parse(resultSet.getString("data_entrada")));
        os.setDataSaida(LocalDateTime.parse(resultSet.getString("data_saida")));
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
        statement.setString(3, String.valueOf(servico.getValor()));
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