<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>

<h1>Cadastro de Ordem de Serviço</h1>
<form action="cadastraos" method="post">
    <label for="dataEntrada">Data de Entrada:</label>
    <input type="date" id="dataEntrada" name="dataEntrada" required><br>

    <label for="dataSaida">Data de Entrega:</label>
    <input type="date" id="dataSaida" name="dataSaida"><br>

    <label for="descricaoServicos">Descrição dos Serviços:</label>
    <textarea id="descricaoServicos" name="descricaoServicos" rows="2" required></textarea><br>

    <label for="valorUnitario">Valor Unitário do Serviço:</label>
    <input type="text" id="valorUnitario" name="valorUnitario" required><br>

    <label for="valorTotal">Valor Total da Ordem de Serviço:</label>
    <input type="text" id="valorTotal" name="valorTotal" required><br>

    <label>Selecione um Cliente:</label>
    <select name="clienteId">
        <c:forEach var="cliente" items="${listaClientes}">
            <option value="${cliente.id}">${cliente.nome}</option>
        </c:forEach>
    </select>

    <label>Selecione um Carro:</label>
    <select name="carroId">
        <c:forEach var="carro" items="${listaCarros}">
            <option value="${carro.id}">${carro.modelo}</option>
        </c:forEach>
    </select><br>

    <button type="submit">Cadastrar Ordem de Serviço</button>
</form>

<c:import url="footer.jsp"/>