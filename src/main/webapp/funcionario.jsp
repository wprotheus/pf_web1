<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>

<h1>Cadastro de Funcionário</h1>
<form action="cadastrafuncionario" method="post">
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required>

    <label for="login">Login:</label>
    <input type="text" id="login" name="login" required>

    <label for="senha">Senha:</label>
    <input type="text" id="senha" name="senha" required>

    <button type="submit">Cadastrar Funcionário</button>
</form>

<c:import url="footer.jsp"/>