package com.wprotheus.DAO.interfaces;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.model.Servico;

import java.util.Set;

public interface ServicoDaoInterface extends AutoCloseable {
    public void cadastrar(Servico servico) throws ErroDAO;

    public Set<Servico> buscar() throws ErroDAO;

    public Servico buscarId() throws ErroDAO;

    public void atualizar(Servico servico) throws ErroDAO;

    public void deletar(int idSer) throws ErroDAO;

    @Override
    void close() throws ErroDAO;
}