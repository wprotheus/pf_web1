package com.wprotheus.control.carro;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.CarroDao;
import com.wprotheus.model.Carro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "buscacarro", value = "/buscacarro")
public class BuscaCarro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        try (CarroDao carroDao = new CarroDao()) {
            int idCarro = Integer.parseInt(id);
            Carro carro = carroDao.buscarId(idCarro);
            request.setAttribute("carro", carro);
            request.getRequestDispatcher("/atualizaCarro.jsp").forward(request, response);
        } catch (ErroDAO | ServletException e) {
        }
    }
}