<%@page import="entity.Duplicata"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Página de Saída</h3>
	<a href="index.jsp">Inicio</a>
	<a href="cadastrar.jsp">Cadastrar</a>
	
	<%
		if(request.getAttribute("duplicata") != null){
			// recuperar atributo
			Duplicata duplicata =(Duplicata) request.getAttribute("duplicata");
			out.print(" ");
			out.print("Cedente: "+duplicata.getCedente() +"\n");
			out.print("/n<br>DataVencimento: "+duplicata.getDataVencimento()+"\n");
			out.print("/n<br>Valor"+duplicata.getValor()+"\n");
			out.print("/n<br>Banco"+duplicata.getBanco()+"\n");
			out.print("/n<br>NotaFiscal"+duplicata.getNotaFiscal()+"\n");
			out.print("/n<br>Pago"+duplicata.getPago()+"\n");
					
					
				}
		%>

		
</body>
</html>