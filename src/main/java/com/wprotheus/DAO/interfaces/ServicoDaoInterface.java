package com.wprotheus.DAO.interfaces;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.model.Servico;

import java.util.Set;

public interface ServicoDaoInterface extends AutoCloseable {
    void cadastrar(Servico servico) throws ErroDAO;

    Set<Servico> buscar() throws ErroDAO;

    Servico buscarId(int idServico) throws ErroDAO;

    void atualizar(Servico servico) throws ErroDAO;

    void deletar(int idServico) throws ErroDAO;

    @Override
    void close() throws ErroDAO;
}