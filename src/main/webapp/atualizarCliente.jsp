<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>

<h1>Atualizar Cliente</h1>
<form action="atualizacliente" method="post">
    <input hidden name="id" value="${cliente.id}">

    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" value="${cliente.nome}" required>

    <label for="endereco">Endereço:</label>
    <input type="text" id="endereco" name="endereco" value="${cliente.endereco}" required>

    <label for="telefone">Telefone:</label>
    <input type="text" id="telefone" name="telefone" value="${cliente.telefone}" required>

    <button type="submit">Atualiza Cliente</button>
</form>
<hr>
<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
<hr>
<c:import url="footer.jsp"/>