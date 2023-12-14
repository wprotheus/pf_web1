package com.wprotheus.control.carro;

import com.wprotheus.DAO.acessos.CarroDao;
import com.wprotheus.model.Carro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "atualizacarro", value = "/atualizacarro")
public class AtualizaCarro extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String modelo = request.getParameter("modelo");
        String marca = request.getParameter("marca");
        String ano = request.getParameter("ano");
        String placa = request.getParameter("placa");

        try (CarroDao carroDao = new CarroDao()) {
            int idCarro = Integer.parseInt(id);
            Carro carro = new Carro(idCarro, modelo, marca, ano, placa);
            carroDao.atualizar(carro);
            response.sendRedirect("listacarro?mensagem=atualizadocomsucesso");
        } catch (Exception e) {
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }
}