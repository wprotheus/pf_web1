package com.wprotheus.control.cliente;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.ClienteDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "deletacliente", value = "/deletacliente")
public class DeletaCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        try (ClienteDao clienteDao = new ClienteDao()) {
            int idCliente = Integer.parseInt(id);
            clienteDao.deletar(idCliente);
            response.sendRedirect("listacliente?mensagem=deletadocomsucesso");
        } catch (ErroDAO e) {
        }
    }
}