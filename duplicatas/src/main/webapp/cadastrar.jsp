<jsp:include page="topo.jsp"></jsp:include>
<h3>Sistema de Gerenciamento de Contas a Pagar</h3>
<a href="index.jsp">voltar</a>
${msg}
<form action="cadastrar.html" method="post">
<div class="form-group">
Informe o Cedente:
<input type="text" name ="cedente" id="cedente" class="form-control"/>
</div>
<div class="form-group">
Informe a Data de Vencimento:
<input type="text" name ="dataVencimento" id="dataVencimento" class="form-control"/>
</div>
<div class="form-group">
Informe o Valor:
<input type="text" name ="valor" id="valor" class="form-control"/>
</div>
<div class="form-group">
Informe o Banco:
<input type="text" name ="banco" id="banco" class="form-control"/>
</div>
<div class="form-group">
Informe o numero da Nota Fiscal:
<input type="text" name ="notaFiscal" id="notaFiscal" class="form-control"/>
</div>
Informe se esta pago:
<input type="text" name ="pago" id="pago" class="form-control"/>
</div>
<br><br>
<input type="submit" value="Cadastrar contas a pagar" id="btn" class="btn btn-primary">

</form>


<jsp:include page="rodape.jsp"></jsp:include>