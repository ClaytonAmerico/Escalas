<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Funcionário</title>
</head>
<body>
	<form:errors path="funcionario.nome"/>
	<form action="adicionaFuncionario" method="post">
		Setor <br/> 
		<select name="idS">
			<c:forEach items="${setores}" var="setor">
				<option value="${setor.idS}">${setor.nome}</option>
			</c:forEach>
		</select> <br/> 
		Código <br /> 
		<input type="text" name="idF" placeholder="Código do Funcioário" /> <br /> 
		Nome <br>
		<textarea name="nome" rows="1" cols="100"></textarea> <br /> 
		Carteira <br> 
		<input name="carteira" /> <br/>
		Horário <br/>
		<select name="idH">
			<c:forEach items="${horarios}" var="horario">
				<option value="${horario.idH}">${horario.inicio} : ${horario.termino} </option>
			</c:forEach>
		</select> <br/> 
		Ativo <br />
		<select name="ativo">
			<option value="1">Sim</option>
			<option value="0">Não</option>
		</select>
		<!--<input name = "ativo"/>-->
		<br /> 
		<input type="submit" value="Adicionar" class="btn btn-primary">
	</form>
</body>
</html>