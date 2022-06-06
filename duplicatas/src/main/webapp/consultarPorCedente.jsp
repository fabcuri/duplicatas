<jsp:include page="topo.jsp"></jsp:include>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h1 class="page-header">Buscar Contas a Pagar por Cedente</h1>

<div class="well">
	<form action="consultarPorCedente.html" method="post">
		<div class="form-group">
			Informe o cedente: <input type="text" name="cedente" class="form-control" />
		</div>
		<input type="submit" value="Buscar" class="btn btn-info" />
	</form>
	${msg}

</div>

<c:if test="${fn:length(lista) >0 }">
	<table class="table table-bordered">
		<tr>
			<th>CEDENTE</th>
			<th>DATAVENCIMENTO</th>
			<th>VALOR</th>
			<th>BANCO</th>
			<th>NOTAFISCAL</th>
				<th>PAGO</th>
		</tr>
		<c:forEach items="${lista }" var="DD">
			<tr>
				<td>${DD.cedente}</td>
				<td>${DD.dataVencimento}</td>
				<td>
				<fmt:formatNumber value="${DD.valor }" 
				type="currency"></fmt:formatNumber>
				</td>
				<td>${DD.banco}</td>
				<td>${DD.notaFiscal}</td>
				<td>${DD.pago}</td>
			
				</td>
				<td>
				<a href="excluir.html?cedente=${DD.idduplicata }"
				onclick="return confirm('Deseja excluir este cedente?')"
				class= "btn btn-danger">Excluir</a>
				</td>
			
				
			</tr>
		</c:forEach>

	</table>
</c:if>

<jsp:include page="rodape.jsp"></jsp:include>



