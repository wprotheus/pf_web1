package com.wprotheus.control;

import com.wprotheus.model.Funcionario;
import com.wprotheus.utils.ValidaCampo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "sair", value = "/sair")
public class Sair extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<body><html>");

        HttpSession session = request.getSession(false);

        if (session!=null)
        {
//            Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
//            out.println("<h2>Volte sempre, " + usuarioLogado.getNome());
            session.invalidate();
            out.println("<br><h3><a href='index.html'>Home</a></h3>");
        }
        else
            out.println("<p>Você não está logado.");
        out.println("</body></html>");
    }
}