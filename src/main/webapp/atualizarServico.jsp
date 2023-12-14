<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>

<h1>Atualizar Servico</h1>
<form action="atualizaservico" method="post">
    <input hidden name="id" value="${servico.id}">

    <label for="nome">Nome (Tipo):</label>
    <input type="text" id="nome" name="nome" value="${servico.nome}" required>

    <label for="descricao">Descrição do Serviço:</label>
    <textarea id="descricao" name="descricao" rows="4" value="${servico.descricao}" required></textarea>

    <label for="valor">Valor do Serviço:</label>
    <input type="text" id="valor" name="valor" value="${servico.valor}" required>

    <button type="submit">Atualizar Serviço</button>
</form>

<c:import url="footer.jsp"/>