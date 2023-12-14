package com.wprotheus.control.cliente;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.ClienteDao;
import com.wprotheus.model.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet(name = "listacliente", value = "/listacliente")
public class ListaCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        try (ClienteDao clienteDao = new ClienteDao()) {
            Set<Cliente> clienteSet = clienteDao.buscar();
            request.setAttribute("clientes", clienteSet);
            request.getRequestDispatcher("/WEB-INF/clientes.jsp").forward(request, response);
            List<Cliente> clientes = (List<Cliente>) clienteDao.buscar();
            request.setAttribute("clientes", clientes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ordemservico.jsp");
            dispatcher.forward(request, response);
        } catch (ErroDAO | ServletException e) {
        }
    }
}