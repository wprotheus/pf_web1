package com.wprotheus.control.cliente;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.ClienteDao;
import com.wprotheus.model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "buscacliente", value = "/buscacliente")
public class BuscaCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        try (ClienteDao clienteDao = new ClienteDao()) {
            int idCliente = Integer.parseInt(id);
            Cliente cliente = clienteDao.buscarId(idCliente);
            request.setAttribute("cliente", cliente);
            request.getRequestDispatcher("/atualizarCliente.jsp").forward(request, response);
        } catch (ErroDAO | ServletException e) {
        }
    }
}