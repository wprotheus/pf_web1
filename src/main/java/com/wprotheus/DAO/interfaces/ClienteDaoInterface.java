package com.wprotheus.DAO.interfaces;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.model.Cliente;

import java.util.Set;

public interface ClienteDaoInterface extends AutoCloseable {
    public void cadastrar(Cliente cliente) throws ErroDAO;

    public Set<Cliente> buscar() throws ErroDAO;

    public Cliente buscarId(int idCliente) throws ErroDAO;

    public void atualizar(Cliente cliente) throws ErroDAO;

    public void deletar(int idCliente) throws ErroDAO;

    @Override
    void close() throws ErroDAO;
}