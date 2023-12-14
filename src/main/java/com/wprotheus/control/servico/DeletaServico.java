package com.wprotheus.control.servico;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.ServicoDao;
import com.wprotheus.utils.ValidaCampo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "deletaservico", value = "/deletaservico")
public class DeletaServico extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        try (ServicoDao servicoDao = new ServicoDao()) {
            if (!ValidaCampo.valido(id))
                return;
            int idServico = Integer.parseInt(id);
            servicoDao.deletar(idServico);
            response.sendRedirect("listaservico?mensagem=deletadocomsucesso");
        } catch (ErroDAO e) {
        }
    }
}