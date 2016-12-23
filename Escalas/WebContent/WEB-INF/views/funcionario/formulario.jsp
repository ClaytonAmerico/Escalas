<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Adicionar Funcionario</h3>
	<form action="adicionaFuncionario" method="post">   
		Setor <br/>                                                   
		<input name = "idS" /> <br/>
		Código <br/>                                                   
		<input name = "idF" /> <br/>                                   
		Nome <br>                                                      
		<textarea name="nome" rows="1" cols="100"></textarea><br />    
		Carteira <br>                                                  
		<input name = "carteira" /> <br/>
		Horário <br/>
		<input name = "idH" /><br/>
		Ativo <br/>
		<input name = "ativo"/>     <br/>                   
		<input type = "submit" value = "Adicionar" >                   
	</form>                                                          
</body>
</html>