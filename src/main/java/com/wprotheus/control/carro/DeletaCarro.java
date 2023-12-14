package com.wprotheus.control.carro;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.CarroDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "deletacarro", value = "/deletacarro")
public class DeletaCarro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        try (CarroDao carroDao = new CarroDao()) {
            int idCarro = Integer.parseInt(id);
            carroDao.deletar(idCarro);
            response.sendRedirect("listacarro?mensagem=deletadocomsucesso");
        } catch (ErroDAO e) {
        }
    }
}