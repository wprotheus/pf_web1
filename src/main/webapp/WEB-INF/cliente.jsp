<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Cliente</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<c:import url="header.jsp" />

<nav>
    <!-- Coloque aqui o menu de navegação, se necessário -->
</nav>

<aside>
    <h2>Cadastro de Cliente</h2>
    <form action="processaCadastroCliente.jsp" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>

        <label for="endereco">Endereço:</label>
        <input type="text" id="endereco" name="endereco" required>

        <label for="telefone">Telefone:</label>
        <input type="text" id="telefone" name="telefone" required>

        <button type="submit">Cadastrar Cliente</button>
    </form>
</aside>

<c:import url="footer.jsp" />
</body>
</html>