package com.wprotheus.control;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.ClienteDao;
import com.wprotheus.model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "cadastraos", value = "/cadastraos")
public class CadastraOS extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");

        Cliente novoCliente = new Cliente(nome, endereco, telefone);

        try (ClienteDao clienteDao = new ClienteDao())
        {
            clienteDao.cadastrar(novoCliente);
            request.getRequestDispatcher("/sucesso.jsp").forward(request, response);
        } catch (ErroDAO e)
        {
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }
}