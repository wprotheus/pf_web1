package com.wprotheus.control.os;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.OrdemServicoDao;
import com.wprotheus.model.OrdemServico;
import com.wprotheus.utils.ValidaCampo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "buscaos", value = "/buscaos")
public class BuscaOS extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        try (OrdemServicoDao ordemServicoDao = new OrdemServicoDao()) {
            if (!ValidaCampo.valido(id))
                return;
            int idOs = Integer.parseInt(id);
            OrdemServico ordemServico = ordemServicoDao.buscarId(idOs);
            request.setAttribute("os", ordemServico);
            request.getRequestDispatcher("/listaos.jsp").forward(request, response);
        } catch (ErroDAO | ServletException e) {

        }
    }
}