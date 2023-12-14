<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<h1>Lista de Serviços</h1>
<hr>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Descrição</th>
        <th>Valor</th>
        <th>Editar</th>
        <th>Deletar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="servico" items="${servicos}">
        <tr>
            <td>${servico.id}</td>
            <td>${servico.nome}</td>
            <td>${servico.descricao}</td>
            <td>${servico.valor}</td>
            <td>
                <a href="${pageContext.request.contextPath}/buscaservico?id=${servico.id}">Editar</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/deleteservico?id=${servico.id}">Deletar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<hr>
<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
<hr>
<c:import url="../footer.jsp"/>