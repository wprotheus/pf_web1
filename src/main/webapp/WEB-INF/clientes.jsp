<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<h1>Lista de Clientes</h1>
<hr>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Endereço</th>
        <th>Telefone</th>
        <th>Editar</th>
        <th>Deletar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="cliente" items="${clientes}">
        <tr>
            <td>${cliente.id}</td>
            <td>${cliente.nome}</td>
            <td>${cliente.endereco}</td>
            <td>${cliente.telefone}</td>
            <td>
                <a href="${pageContext.request.contextPath}/buscacliente?id=${cliente.id}">Editar</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/deletecliente?id=${cliente.id}">Deletar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:import url="../footer.jsp"/>