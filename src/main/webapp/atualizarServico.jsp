<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>

<h1>Atualizar Servico</h1>
<form action="atualizaservico" method="post">
    <input hidden name="id" value="${servico.id}">

    <label for="nome">Nome:</label>
    <input style="width: 600px;" type="text" id="nome" name="nome" value="${servico.nome}" required><br>

    <label for="descricao">Descrição do Serviço:</label>
    <input style="width: 800px;" id="descricao" name="descricao" aria-multiline="true" value="${servico.descricao}" required><br>

    <label for="valor">Valor do Serviço:</label>
    <input style="width: 100px;" type="text" id="valor" name="valor" value="${servico.valor}" required><br>

    <button type="submit">Atualizar Serviço</button>
</form>
<hr>
<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
<hr>
<c:import url="footer.jsp"/>