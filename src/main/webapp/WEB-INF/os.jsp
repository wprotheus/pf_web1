<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<h1>Lista de Ordens de Serviço</h1>
<hr>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Data de Entrada</th>
        <th>Data de Saída</th>
        <th>Descrição do Serviço</th>
        <th>Valor do Serviço</th>
        <th>Valor Total</th>
        <th>ID Cliente</th>
        <th>ID Carro</th>
        <th>Editar</th>
        <th>Deletar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ordem" items="${ordens}">
        <tr>
            <td>${ordem.id}</td>
            <td>${ordem.dataEntrada}</td>
            <td>${ordem.dataSaida}</td>
            <td>${ordem.descServico}</td>
            <td>${ordem.valorServico}</td>
            <td>${ordem.valorTotal}</td>
            <td>${ordem.cliente.id}</td> <!-- Use o atributo correto para o ID do cliente -->
            <td>${ordem.carro.id}</td> <!-- Use o atributo correto para o ID do carro -->
            <td>
                <a href="${pageContext.request.contextPath}/editaordemservico?id=${ordem.id}">Editar</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/deleteordemservico?id=${ordem.id}">Deletar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:import url="../footer.jsp"/>
