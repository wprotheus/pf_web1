package com.wprotheus.DAO.interfaces;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.model.Carro;

import java.util.Set;

public interface CarroDaoInterface extends AutoCloseable {
    public void cadastrar(Carro carro) throws ErroDAO;

    public Set<Carro> buscar() throws ErroDAO;

    public Carro buscarId(int idCarro) throws ErroDAO;

    public void atualizar(Carro carro) throws ErroDAO;

    public void deletar(int idCarro) throws ErroDAO;

    @Override
    void close() throws ErroDAO;
}