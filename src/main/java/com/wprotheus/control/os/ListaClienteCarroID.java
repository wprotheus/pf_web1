package com.wprotheus.control.os;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.CarroDao;
import com.wprotheus.DAO.acessos.ClienteDao;
import com.wprotheus.model.Carro;
import com.wprotheus.model.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "listaclientecarroid", value = "/listaclientecarroid")
public class ListaClienteCarroID extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        Set<Cliente> listaClientes;
        try (ClienteDao clienteDAO = new ClienteDao();) {

            listaClientes = clienteDAO.buscar();
        } catch (ErroDAO e) {
            throw new RuntimeException(e);
        }

        Set<Carro> listaCarros;
        try (CarroDao carroDAO = new CarroDao()) {

            listaCarros = carroDAO.buscar();

        } catch (ErroDAO e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("listaClientes", listaClientes);
        request.setAttribute("listaCarros", listaCarros);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ordemservico.jsp");
        dispatcher.forward(request, response);
    }
}