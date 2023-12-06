package com.wprotheus.DAO.interfaces;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.model.Funcionario;

import java.util.Set;

public interface FuncionarioDaoInterface extends AutoCloseable {
    public void cadastrar(Funcionario funcionario) throws ErroDAO;

    public Set<Funcionario> buscar() throws ErroDAO;

    public Funcionario buscar(String login, String senha) throws ErroDAO;

    public void atualizar(Funcionario funcionario) throws ErroDAO;

    public void deletar(int idFunc) throws ErroDAO;

    @Override
    void close() throws ErroDAO;
}