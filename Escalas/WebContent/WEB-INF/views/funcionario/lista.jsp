<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="novoFuncionario">Cadastrar novo funcionário</a>
	
	<table>
		<tr>			
			<th>Código</th>
			<th>Nome</th>
			<th>Carteira</th>
			<th>Ativo</th>
		</tr>
		<c:forEach items="${funcionarios}" var="funcionario">
			<tr>
				<td>${funcionario.idF}</td>
				<td>${funcionario.nome}</td>
				<td>${funcionario.carteira}</td>
				<c:if test="${funcionario.situacao == 0}">
					<td>Não</td>
				</c:if>
				<c:if test="${funcionario.situacao == 1}">
					<td>Sim</td>
				</c:if>
				<!-- <td>
				<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
				</td>  -->
			</tr>
		</c:forEach>
	</table>
</body>
</html>