<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cadastro de Serviço</title>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<c:import url="header.jsp" />

<nav>
  <!-- Coloque aqui o menu de navegação, se necessário -->
</nav>

<aside>
  <h2>Cadastro de Serviço</h2>
  <form action="processaCadastroServico.jsp" method="post">
    <label for="nome">Nome (Tipo):</label>
    <input type="text" id="nome" name="nome" required>

    <label for="descricao">Descrição do Serviço:</label>
    <textarea id="descricao" name="descricao" rows="4" required></textarea>

    <label for="valor">Valor do Serviço:</label>
    <input type="text" id="valor" name="valor" required>

    <button type="submit">Cadastrar Serviço</button>
  </form>
</aside>

<c:import url="footer.jsp" />
</body>
</html>