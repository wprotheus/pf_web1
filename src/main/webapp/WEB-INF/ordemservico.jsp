<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Ordem de Serviço</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<c:import url="header.jsp" />

<nav>
    <!-- Coloque aqui o menu de navegação, se necessário -->
</nav>

<aside>
    <h2>Cadastro de Ordem de Serviço</h2>
    <form action="processaCadastroOrdem.jsp" method="post">
        <label for="dataEntrada">Data de Entrada:</label>
        <input type="date" id="dataEntrada" name="dataEntrada" required>

        <label for="dataEntrega">Data de Entrega:</label>
        <input type="date" id="dataEntrega" name="dataEntrega" required>

        <label for="descricaoServicos">Descrição dos Serviços:</label>
        <textarea id="descricaoServicos" name="descricaoServicos" rows="4" required></textarea>

        <label for="valorUnitario">Valor Unitário do Serviço:</label>
        <input type="text" id="valorUnitario" name="valorUnitario" required>

        <label for="valorTotal">Valor Total da Ordem de Serviço:</label>
        <input type="text" id="valorTotal" name="valorTotal" required>

        <label for="clienteCarroRelacionamento">Relacionamento Cliente-Carro:</label>
        <input type="text" id="clienteCarroRelacionamento" name="clienteCarroRelacionamento" required>

        <button type="submit">Cadastrar Ordem de Serviço</button>
    </form>
</aside>

<c:import url="footer.jsp" />
</body>
</html>