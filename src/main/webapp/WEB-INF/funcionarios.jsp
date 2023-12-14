<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<h1>Lista de Funcionários</h1>
<hr>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Login</th>
        <th>Editar</th>
        <th>Deletar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="funcionario" items="${funcionarios}">
        <tr>
            <td>${funcionario.id}</td>
            <td>${funcionario.nome}</td>
            <td>${funcionario.login}</td>
            <td>
                <a href="${pageContext.request.contextPath}/buscafuncionario?id=${funcionario.id}">Editar</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/deletefuncionario?id=${funcionario.id}">Deletar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<hr>
<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
<hr>
<c:import url="../footer.jsp"/>