package com.wprotheus.control.os;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.CarroDao;
import com.wprotheus.DAO.acessos.OrdemServicoDao;
import com.wprotheus.utils.ValidaCampo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "deletaos", value = "/deletaos")
public class DeletaOS extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        try (OrdemServicoDao ordemServicoDao = new OrdemServicoDao()) {
            if (!ValidaCampo.valido(id))
                return;
            int idOs = Integer.parseInt(id);
            ordemServicoDao.deletar(idOs);
            response.sendRedirect("listaos?mensagem=deletadocomsucesso");
        } catch (ErroDAO e)
        {}
    }
}