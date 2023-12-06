package com.wprotheus.control;

import com.wprotheus.DAO.acessos.CarroDao;
import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.model.Carro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "cadastracarro", value = "/cadastracarro")
public class CadastraCarro extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String modelo = request.getParameter("modelo");
        String marca = request.getParameter("marca");
        String ano = request.getParameter("ano");
        String placa = request.getParameter("placa");

        Carro novoCarro = new Carro(modelo, marca, ano, placa);

        try (CarroDao carroDao = new CarroDao())
        {
            carroDao.cadastrar(novoCarro);
            request.getRequestDispatcher("WEB-INF/sucesso.jsp").forward(request, response);
        } catch (ErroDAO e)
        {
            request.getRequestDispatcher("WEB-INF/erro.jsp").forward(request, response);
        }
    }
}