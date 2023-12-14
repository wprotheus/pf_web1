package com.wprotheus.control.cliente;

import com.wprotheus.DAO.acessos.ClienteDao;
import com.wprotheus.model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "atualizacliente", value = "/atualizacliente")
public class AtualizaCliente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");

        try (ClienteDao clienteDao = new ClienteDao()) {
            int idCliente = Integer.parseInt(id);
            Cliente cliente = new Cliente(idCliente, nome, endereco, telefone);
            clienteDao.atualizar(cliente);
            response.sendRedirect("listacliente?mensagem=atualizadocomsucesso");
        } catch (Exception e) {
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }
}