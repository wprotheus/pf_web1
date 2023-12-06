<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/header.jsp" %>

<main class="clearfix">
    <form action="logar" method="post">
        <label for="username">Usuário:</label>
        <input type="text" id="username" name="login" required>

        <label for="password">Senha:</label>
        <input type="password" id="password" name="senha" required>

        <button type="submit">Login</button>
    </form>
</main>

<%@ include file="WEB-INF/footer.jsp" %>