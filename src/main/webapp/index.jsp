<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>

<div class="menu">
    <nav>
        <ul>
            <li><a href="cliente.jsp">Cadastro de Clientes</a></li>
            <li><a href="listacliente">Listar Clientes</a></li>
            <li><a href="funcionario.jsp">Cadastro de Funcionários</a></li>
            <li><a href="listafuncionario">Listar Funcionários</a></li>
            <li><a href="carro.jsp">Cadastro de Carros</a></li>
            <li><a href="listacarro">Listar Carros</a></li>
            <li><a href="servico.jsp">Cadastro de Serviços</a></li>
            <li><a href="listaservico">Listar Serviços</a></li>
            <li><a href="listaclientecarroid">Cadastro de Ordens de Serviço</a></li>
            <li><a href="listaos">Listar Ordens de Serviço</a></li>
            <li><a href="sair">Sair</a></li>
        </ul>
    </nav>
</div>

<div class="sistemas">
</div>

<c:import url="footer.jsp"/>