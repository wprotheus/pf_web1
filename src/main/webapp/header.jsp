<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sua Oficina Mecânica</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<header>
    <h1>Sistema de Gerenciador de Oficina</h1>
    <c:if test="${not empty sessionScope.usuario}">
        <p>Olá ${sessionScope.usuario.nome}</p>
    </c:if>
</header>
