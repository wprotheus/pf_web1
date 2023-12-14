<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>

<h1>Atualizar Carro</h1>
<form action="atualizacarro" method="post">
    <input hidden name="id" value="${carro.id}">

    <label for="modelo">Modelo:</label>
    <input type="text" id="modelo" name="modelo" value="${carro.modelo}" required>

    <label for="marca">Marca:</label>
    <input type="text" id="marca" name="marca" value="${carro.marca}" required>

    <label for="ano">Ano:</label>
    <input type="text" id="ano" name="ano" value="${carro.ano}" required>

    <label for="placa">Placa:</label>
    <input type="text" id="placa" name="placa" value="${carro.placa}" required>

    <button type="submit">Atualizar Carro</button>
</form>

<c:import url="footer.jsp"/>