<%@page import="dao.DuplicataDao"%>
<%@page import="java.util.List"%>
<%@page import= "entity.Duplicata"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pesquisa Boletos</title>
</head>
<body>
<a href="index.jsp">voltar</a>
<br><br>
<h3>Listar Boletos</h3>


<hr>


<br><br>
<%
List<Duplicata> lista = new DuplicataDao().listar();
if(lista.size()>0){
	for(Duplicata d: lista){
		out.print("<br>Cedente "+d.getCedente());
		out.print("<br>DataVencimento "+d.getDataVencimento());
		out.print("<br>Valor "+d.getValor());
		out.print("<br> Banco "+d.getBanco());
		out.print("<br> NotaFical "+d.getNotaFiscal());
		out.print("<br> Pago "+d.getPago());
		out.print("<br><br><br>");
		
	}
}
%>
</body>
</html>