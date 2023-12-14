package com.wprotheus.DAO.interfaces;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.model.Carro;
import com.wprotheus.model.Cliente;
import com.wprotheus.model.OrdemServico;
import com.wprotheus.model.Servico;

import java.util.Set;

public interface ServicoOrdemServicoDaoInterface extends AutoCloseable {

    void relacionarServicoOS(Servico servico, OrdemServico ordemServico) throws ErroDAO;

    Set<Servico> listarServicosOS(OrdemServico ordemServico) throws ErroDAO;

    Set<OrdemServico> listarOSCliente(Cliente cliente) throws ErroDAO;

    Set<OrdemServico> listarOSCarro(Carro carro) throws ErroDAO;

    @Override
    void close() throws ErroDAO;
}
