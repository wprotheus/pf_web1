<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../header.jsp"/>

<h1>Relação de Serviços e Ordens de Serviço</h1>
<hr>
<table>
    <thead>
    <tr>
        <th>ID do Serviço</th>
        <th></th>
        <th>ID da Ordem de Serviço</th>
        <th></th>
        <th>Editar</th>
        <th>Deletar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="relacao" items="${relacoesServicoOrdemServico}">
        <tr>
            <td>${relacao.idServico}</td>
            <td>${relacao.idOrdemServico}</td>
            <td>
                <a href="${pageContext.request.contextPath}/editarelacao?idServico=${relacao.idServico}&idOrdemServico=${relacao.idOrdemServico}">Editar</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/deleterelacao?idServico=${relacao.idServico}&idOrdemServico=${relacao.idOrdemServico}">Deletar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:import url="../footer.jsp"/>
