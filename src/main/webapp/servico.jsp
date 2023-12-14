<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="header.jsp"/>

<h2>Cadastro de Serviço</h2>
<form action="cadastraservico" method="post">
    <label for="nome">Nome (Tipo):</label>
    <input type="text" id="nome" name="nome" required>

    <label for="descricao">Descrição do Serviço:</label>
    <textarea id="descricao" name="descricao" rows="4" required></textarea>

    <label for="valor">Valor do Serviço:</label>
    <input type="text" id="valor" name="valor" required>

    <button type="submit">Cadastrar Serviço</button>
</form>

<c:import url="footer.jsp"/>