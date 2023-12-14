package com.wprotheus.control.os;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.OrdemServicoDao;
import com.wprotheus.model.OrdemServico;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "listaos", value = "/listaos")
public class ListaOS extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        try (OrdemServicoDao ordemServicoDao = new OrdemServicoDao()) {
            Set<OrdemServico> ordemServicoSet = ordemServicoDao.buscar();
            request.setAttribute("ordens", ordemServicoSet);
            request.getRequestDispatcher("/WEB-INF/os.jsp").forward(request, response);
        } catch (ErroDAO | ServletException e) {
        }
    }
}