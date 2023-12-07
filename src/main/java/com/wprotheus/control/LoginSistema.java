package com.wprotheus.control;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.FuncionarioDao;
import com.wprotheus.model.Funcionario;
import com.wprotheus.utils.ValidaCampo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(name = "logar", value = "/logar")
public class LoginSistema extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        try {
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            if (ValidaCampo.valido(login) && ValidaCampo.valido(senha))
            {
                Funcionario funcionario = funcionarioDao.buscar(login, senha);
                if(funcionario.getLogin().equals(login) && funcionario.getSenha().equals(senha))
                {
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("funcionario", funcionario);
                    response.sendRedirect("index.jsp");
                }
                else
                    response.sendRedirect("login.jsp?error=invalid");
            }
        } catch ( RuntimeException | IOException | ErroDAO e) {
            throw new ErroDAO(e);
        }
    }
}