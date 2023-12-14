package com.wprotheus.control.servico;

import com.wprotheus.DAO.acessos.ServicoDao;
import com.wprotheus.model.Servico;
import com.wprotheus.utils.ValidaCampo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "atualizaservico", value = "/atualizaservico")
public class AtualizaServico extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String valor = request.getParameter("valor");

        try (ServicoDao servicoDao = new ServicoDao()) {
            int idServico = Integer.parseInt(id);
            BigDecimal valorServico = null;
            if (!ValidaCampo.valido(valor))
                return;
            valorServico = new BigDecimal(valor);
            Servico servico = new Servico(idServico, nome, descricao, valorServico);
            servicoDao.atualizar(servico);
            response.sendRedirect("listaservico?mensagem=atualizadocomsucesso");
        } catch (Exception e) {
            response.sendRedirect("/erro.jsp");
        }
    }
}