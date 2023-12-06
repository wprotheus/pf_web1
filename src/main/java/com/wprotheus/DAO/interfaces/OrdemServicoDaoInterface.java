package com.wprotheus.DAO.interfaces;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.model.OrdemServico;

import java.util.Set;

public interface OrdemServicoDaoInterface extends AutoCloseable {
    public void cadastrar(OrdemServico ordemServico) throws ErroDAO;

    public Set<OrdemServico> buscar() throws ErroDAO;

    public OrdemServico buscarId() throws ErroDAO;

    public void atualizar(OrdemServico ordemServico) throws ErroDAO;

    public void deletar(int idOS) throws ErroDAO;

    @Override
    void close() throws ErroDAO;
}