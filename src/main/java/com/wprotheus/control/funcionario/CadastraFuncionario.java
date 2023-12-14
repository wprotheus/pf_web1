package com.wprotheus.control.funcionario;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.FuncionarioDao;
import com.wprotheus.model.Funcionario;
import com.wprotheus.utils.ValidaCampo;
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
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        try (FuncionarioDao funcionarioDao = new FuncionarioDao()) {
            if (!ValidaCampo.valido(nome) && !ValidaCampo.valido(login) && !ValidaCampo.valido(senha))
                return;
            Funcionario novoFuncionario = new Funcionario(nome, login, senha);
            funcionarioDao.cadastrar(novoFuncionario);
            request.getRequestDispatcher("/sucesso.jsp").forward(request, response);
        } catch (ErroDAO e) {
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }
}