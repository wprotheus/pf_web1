package com.wprotheus.control.servico;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.ServicoDao;
import com.wprotheus.model.Servico;
import com.wprotheus.utils.ValidaCampo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "buscaservico", value = "/buscaservico")
public class BuscaServico extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        try (ServicoDao servicoDao = new ServicoDao()) {
            if (!ValidaCampo.valido(id))
                return;
            int idServico = Integer.parseInt(id);
            Servico servico = servicoDao.buscarId(idServico);
            request.setAttribute("servico", servico);
            request.getRequestDispatcher("/atualizarServico.jsp").forward(request, response);
        } catch (ErroDAO | ServletException e) {
        }
    }
}