package com.wprotheus.control.cliente;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.ClienteDao;
import com.wprotheus.model.Cliente;
import com.wprotheus.utils.ValidaCampo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "cadastracliente", value = "/cadastracliente")
public class CadastraCliente extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");

        try (ClienteDao clienteDao = new ClienteDao()) {
            if (!ValidaCampo.valido(nome) && !ValidaCampo.valido(endereco) && !ValidaCampo.valido(telefone))
                return;
            Cliente novoCliente = new Cliente(nome, endereco, telefone);
            clienteDao.cadastrar(novoCliente);
            request.getRequestDispatcher("/sucesso.jsp").forward(request, response);
        } catch (ErroDAO e) {
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }
}