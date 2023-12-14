<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<h1>Lista de Carros</h1>
<hr>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Modelo</th>
        <th>Marca</th>
        <th>Ano</th>
        <th>Placa</th>
        <th>Editar</th>
        <th>Deletar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="carros" items="${carros}">
        <tr>
            <td>${carros.id}</td>
            <td>${carros.modelo}</td>
            <td>${carros.marca}</td>
            <td>${carros.ano}</td>
            <td>${carros.placa}</td>
            <td>
                <a href="${pageContext.request.contextPath}/buscacarro?id=${carros.id}">Editar</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/deletacarro?id=${carros.id}">Deletar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<hr>
<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
<hr>
<c:import url="../footer.jsp"/>
