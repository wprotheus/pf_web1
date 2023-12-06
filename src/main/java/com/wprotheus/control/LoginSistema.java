package com.wprotheus.control;

import com.wprotheus.utils.ValidaCampo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "logar", value = "/logar")
public class LoginSistema extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String page = request.getParameter("page");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        if (ValidaCampo.valido(login) && ValidaCampo.valido(senha)) {
            if (login.equals("admin") && senha.equals("@dm!n")) {
                System.out.println("Chegou aqui.");
                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            }
        }


    }
}