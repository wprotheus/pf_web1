package com.wprotheus.control.servico;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.ServicoDao;
import com.wprotheus.model.Servico;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "listaservico", value = "/listaservico")
public class ListaServico extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        try (ServicoDao servicoDao = new ServicoDao()) {
            Set<Servico> servicoSet = servicoDao.buscar();
            request.setAttribute("servicos", servicoSet);
            request.getRequestDispatcher("/WEB-INF/servicos.jsp").forward(request, response);
        } catch (ErroDAO | ServletException e) {
        }
    }
}