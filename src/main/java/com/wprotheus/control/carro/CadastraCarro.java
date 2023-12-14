package com.wprotheus.control.carro;

import com.wprotheus.DAO.ErroDAO;
import com.wprotheus.DAO.acessos.CarroDao;
import com.wprotheus.model.Carro;
import com.wprotheus.utils.ValidaCampo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "cadastracarro", value = "/cadastracarro")
public class CadastraCarro extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String modelo = request.getParameter("modelo");
        String marca = request.getParameter("marca");
        String ano = request.getParameter("ano");
        String placa = request.getParameter("placa");

        try (CarroDao carroDao = new CarroDao()) {
            if (!ValidaCampo.valido(modelo) && !ValidaCampo.valido(marca) &&
                    !ValidaCampo.valido(ano) && !ValidaCampo.valido(placa))
                return;
            Carro novoCarro = new Carro(modelo, marca, ano, placa);
            carroDao.cadastrar(novoCarro);
            request.getRequestDispatcher("/sucesso.jsp").forward(request, response);
        } catch (ErroDAO e) {
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }
}