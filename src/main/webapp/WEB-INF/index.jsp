<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>

<div class="menuCabecalho">
    <h2>Bem-vindo à Sua Oficina Mecânica</h2>
    <p>Escolha uma opção no menu abaixo para começar.</p>
</div>
<div class="menu">
    <nav>
        <ul>
            <li><a href="cliente.jsp">Cadastro de Clientes</a></li>
            <li><a href="listarcliente.jsp">Listar Clientes</a></li>
            <li><a href="funcionario.jsp">Cadastro de Funcionários</a></li>
            <li><a href="listarfuncionario.jsp">Listar Funcionários</a></li>
            <li><a href="carro.jsp">Cadastro de Carros</a></li>
            <li><a href="listarcarro.jsp">Listar Carros</a></li>
            <li><a href="servico.jsp">Cadastro de Serviços</a></li>
            <li><a href="listarservico.jsp">Listar Serviços</a></li>
            <li><a href="ordemservico.jsp">Cadastro de Ordens de Serviço</a></li>
            <li><a href="listarordemservico.jsp">Listar Ordens de Serviço</a></li>
            <li><a href="sair.jsp">Sair</a></li>
        </ul>
    </nav>
</div>

<div class="sistemas">
</div>

<c:import url="footer.jsp"/>