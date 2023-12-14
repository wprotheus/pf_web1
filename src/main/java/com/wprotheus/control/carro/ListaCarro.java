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
import java.util.Set;

@WebServlet(name = "listacarro", value = "/listacarro")
public class ListaCarro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        try (CarroDao carroDao = new CarroDao()) {
            Set<Carro> carroSet = carroDao.buscar();
            request.setAttribute("carros", carroSet);
            request.getRequestDispatcher("/WEB-INF/carros.jsp").forward(request, response);
        } catch (ErroDAO | ServletException e) {
        }
    }
}