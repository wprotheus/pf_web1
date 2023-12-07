package com.wprotheus.control;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.ClienteDao;
import com.wprotheus.DAO.acessos.FuncionarioDao;
import com.wprotheus.model.Cliente;
import com.wprotheus.model.Funcionario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "cadastrafuncionario", value = "/cadastrafuncionario")
public class CadastraFuncionario extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Funcionario novoFuncionario = new Funcionario(nome, login, senha);

        try (FuncionarioDao funcionarioDao = new FuncionarioDao())
        {
            funcionarioDao.cadastrar(novoFuncionario);
            request.getRequestDispatcher("/sucesso.jsp").forward(request, response);
        } catch (ErroDAO e)
        {
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }
}