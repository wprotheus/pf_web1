package com.wprotheus.control.os;

import com.wprotheus.DAO.acessos.CarroDao;
import com.wprotheus.DAO.acessos.ClienteDao;
import com.wprotheus.DAO.acessos.OrdemServicoDao;
import com.wprotheus.model.Carro;
import com.wprotheus.model.Cliente;
import com.wprotheus.model.OrdemServico;
import com.wprotheus.utils.ValidaCampo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@WebServlet(name = "atualizaos", value = "/atualizaos")
public class AtualizaOS extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String data_entrada = request.getParameter("data_entrada");
        String data_saida = request.getParameter("data_saida");
        String desc_servico = request.getParameter("desc_servico");
        String valor_servico = request.getParameter("valor_servico");
        String valor_total = request.getParameter("valor_total");
        String tb_carro_id = request.getParameter("tb_carro_id");
        String tb_cliente_id = request.getParameter("tb_cliente_id");

        try (OrdemServicoDao ordemServicoDao = new OrdemServicoDao()) {
            LocalDateTime dataEntrada = null;
            LocalDateTime dataSaida = null;
            BigDecimal valorServico = null;
            BigDecimal valorTotal = null;
            int idOS;
            int idCarro;
            int idCliente;
            if (!ValidaCampo.valido(id) && !ValidaCampo.valido(data_entrada) && !ValidaCampo.valido(desc_servico) &&
                    !ValidaCampo.valido(valor_servico) && !ValidaCampo.valido(valor_total) &&
                    !ValidaCampo.valido(tb_carro_id) && !ValidaCampo.valido(tb_cliente_id))
                return;

            idOS = Integer.parseInt(id);
            idCarro = Integer.parseInt(tb_carro_id);
            idCliente = Integer.parseInt(tb_cliente_id);
            dataEntrada = LocalDateTime.parse(data_entrada);
            dataSaida = LocalDateTime.parse("200-01-01");
            valorServico = new BigDecimal(valor_servico);
            valorTotal = new BigDecimal(valor_total);

            CarroDao carroDao = new CarroDao();
            ClienteDao clienteDao = new ClienteDao();
            Carro carro = carroDao.buscarId(idCarro);
            Cliente cliente = clienteDao.buscarId(idCliente);

            OrdemServico ordemServico = new OrdemServico(idOS, dataEntrada, dataSaida, desc_servico, valorServico, valorTotal, carro, cliente);
            ordemServicoDao.atualizar(ordemServico);
            response.sendRedirect("listaos?mensagem=atualizadocomsucesso");
        } catch (Exception e) {
            response.sendRedirect("/erro.jsp");
        }
    }
}