package entity;

public class Duplicata {
private int idduplicata;
private String cedente;
private String dataVencimento;
private String valor;
private String banco;
private String notaFiscal;
private String pago;
public Duplicata() {
	super();
	// TODO Auto-generated constructor stub
}
public Duplicata(int idduplicata, String cedente, String dataVencimento, String valor, String banco, String notaFiscal,
		String pago) {
	super();
	this.idduplicata = idduplicata;
	this.cedente = cedente;
	this.dataVencimento = dataVencimento;
	this.valor = valor;
	this.banco = banco;
	this.notaFiscal = notaFiscal;
	this.pago = pago;
}

public int getIdduplicata() {
	return idduplicata;
}
public void setIdduplicata(int idduplicata) {
	this.idduplicata = idduplicata;
}
public String getCedente() {
	return cedente;
}
public void setCedente(String cedente) {
	this.cedente = cedente;
}
public String getDataVencimento() {
	return dataVencimento;
}
public void setDataVencimento(String dataVencimento) {
	this.dataVencimento = dataVencimento;
}
public String getValor() {
	return valor;
}
public void setValor(String valor) {
	this.valor = valor;
}
public String getBanco() {
	return banco;
}
public void setBanco(String banco) {
	this.banco = banco;
}
public String getNotaFiscal() {
	return notaFiscal;
}
public void setNotaFiscal(String notaFiscal) {
	this.notaFiscal = notaFiscal;
}
public String getPago() {
	return pago;
}
public void setPago(String pago) {
	this.pago = pago;
}
}
