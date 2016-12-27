<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Alterar Dados Funcionário - ${funcionario.idF}</h3>
	<form action="alteraTarefa" method="post">
		<input type="hidden" name="idF" value="${funcionario.idF}" />
		Nome:<br />
		<textarea name="nome" cols="100" rows="5">${funcionario.nome}</textarea>
		<br />
		Carteira <br> 
		<input name="carteira" value = "${funcionario.carteira}" /> <br/>
		Horário <br/>
		<select name="idH" value = "${horario.inicio} : ${horario.termino}">
			<c:forEach items="${horarios}" var="horario">
				<option value="${horario.idH}">${horario.inicio} : ${horario.termino} </option>
			</c:forEach>
		</select> <br/>
		Inativo? <input type="checkbox" name="inativo" value="0" ${funcionario.situacao? 'checked' : '' }/> <br />
		<!-- Data de finalização: <br />
		<input type="text" name="dataFinalizacao" value="<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" />"/>
		<br />  -->
		<input type="submit" value="Alterar"/> 
		Linha 172
	</form>
</body>
</html>