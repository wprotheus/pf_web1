<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>

<h2>Cadastro de Carro</h2>
<form action="cadastracarro" method="post">
    <label for="modelo">Modelo:</label>
    <input type="text" id="modelo" name="modelo" required>

    <label for="marca">Marca:</label>
    <input type="text" id="marca" name="marca" required>

    <label for="ano">Ano:</label>
    <input type="text" id="ano" name="ano" required>

    <label for="placa">Placa:</label>
    <input type="text" id="placa" name="placa" required>

    <button type="submit">Cadastrar Carro</button>E
</form>

<c:import url="footer.jsp"/>