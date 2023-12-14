package com.wprotheus.control.funcionario;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.FuncionarioDao;
import com.wprotheus.model.Funcionario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "listafuncionario", value = "/listafuncionario")
public class ListaFuncionario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        try (FuncionarioDao funcionarioDao = new FuncionarioDao()) {
            Set<Funcionario> funcionarioSet = funcionarioDao.buscar();
            request.setAttribute("funcionarios", funcionarioSet);
            request.getRequestDispatcher("/WEB-INF/funcionarios.jsp").forward(request, response);
        } catch (ErroDAO | ServletException e) {
        }
    }
}