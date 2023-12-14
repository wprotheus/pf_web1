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
import java.math.BigDecimal;

@WebServlet(name = "cadastraservico", value = "/cadastraservico")
public class CadastraServico extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String valor = request.getParameter("valor");

        try (ServicoDao servicoDao = new ServicoDao()) {
            if (!ValidaCampo.valido(valor))
                return;
            BigDecimal valor_servico = new BigDecimal(valor);
            Servico novoServico = new Servico(nome, descricao, valor_servico);
            servicoDao.cadastrar(novoServico);
            request.getRequestDispatcher("/sucesso.jsp").forward(request, response);
        } catch (ErroDAO e) {
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }
}