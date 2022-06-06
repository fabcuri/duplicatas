package dao;

import java.util.ArrayList;


import java.util.Arrays;
import java.util.List;

import entity.Duplicata;
;



public class DuplicataDao extends Dao{
	public boolean gravar(Duplicata duplicata) throws Exception{
		boolean result=false;
		try {
			//abrir conexão banco
			open();
			//montar sql
			stmt=con.prepareStatement("insert into duplicata values(null,?,?,?,?,?,?)");
			//adiconar valores no sql
			stmt.setString(1, duplicata.getCedente());
			stmt.setString(2, duplicata.getDataVencimento());
			stmt.setString(3, duplicata.getValor());
			stmt.setString(4,duplicata.getBanco());
			stmt.setString(5, duplicata.getNotaFiscal());
			stmt.setString(6, duplicata.getPago() );
			stmt.execute();
			//resultado verdadeiro
			result=true;
		}catch(Exception e){
			result=false;
			
		}finally {
			close();
		}
		
		return result;
	}
public List<Duplicata> consultar()throws Exception{
	open();
	List<Duplicata> lista= new ArrayList<Duplicata>();
	stmt=con.prepareStatement("select * from duplicata");
	rs = stmt.executeQuery();
	while(rs.next()) {

		Duplicata duplicata= new Duplicata(rs.getInt("idduplicata"), 
				rs.getString("cedente"),rs.getString("dataVencimento"),
				rs.getString("valor"),rs.getString("banco"),rs.getString("notaFiscal"),rs.getString("pago"));
		//adicionar o funcionario na lista
		lista.add(duplicata);
	}
	close();
	return lista;
}
public List<Duplicata> consultarPorData(String dataVencimento)throws Exception{
	List<Duplicata> lista= new ArrayList<Duplicata>();
	int valorPagar=0;
	try {
		open();
		stmt=con.prepareStatement("select * from duplicata where dataVencimento = ?");
		stmt.setString(1, dataVencimento);
		rs=stmt.executeQuery();
		while(rs.next()) {


		Duplicata duplicata= new Duplicata(rs.getInt("idduplicata"), 
				rs.getString("cedente"),rs.getString("dataVencimento"),
				rs.getString("valor"),rs.getString("banco"),rs.getString("notaFiscal"),rs.getString("pago"));
		//adicionar o funcionario na lista
		lista.add(duplicata);
		
	}
	close();
	return lista;
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		close();
	}
	return lista;
}
public List<Duplicata> consultarPorCedente(String cedente)throws Exception{
	List<Duplicata> lista= new ArrayList<Duplicata>();
	try {
		open();
		stmt=con.prepareStatement("select * from duplicata where cedente = ?");
		stmt.setString(1, cedente);
		rs=stmt.executeQuery();
		while(rs.next()) {


		Duplicata duplicata= new Duplicata(rs.getInt("idduplicata"), 
				rs.getString("cedente"),rs.getString("dataVencimento"),
				rs.getString("valor"),rs.getString("banco"),rs.getString("notaFiscal"),rs.getString("pago"));
		//adicionar o funcionario na lista
		lista.add(duplicata);
	}
	close();
	return lista;
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		close();
	}
	return lista;
}
public boolean excluir(Integer id) throws Exception {
	boolean sucess=false;
	try {
		open();
		stmt=con.prepareStatement ("delete from duplicata where idduplicata=?");
		stmt.setInt(1, id);
		stmt.execute();
		System.out.println("Excluiu");
		sucess= true;
	} catch (Exception e) {
	e.printStackTrace();
	}finally{
		close();
	}
	return sucess;
}

public List<Duplicata> listar()throws Exception{
	open();
	List<Duplicata> lista= new ArrayList<Duplicata>();
	stmt=con.prepareStatement("select * from duplicata");
	rs = stmt.executeQuery();
	while(rs.next()) {
	
		Duplicata d= new Duplicata(rs.getInt("idduplicata"), 
				rs.getString("cedente"),rs.getString("dataVencimento"),
				rs.getString("valor"),rs.getString("banco"),rs.getString("notaFiscal"),rs.getString("pago"));
		//adicionar o funcionario na lista
		lista.add(d);
	}
	close();
	return lista;
}

public void valorPagar() throws Exception{
List<Duplicata> lista = new DuplicataDao().listar();
int valorPagar=0;
if(lista.size()>0){
	for(Duplicata d: lista){
		valorPagar= valorPagar+(Integer.parseInt(d.getValor()));
		
	}	System.out.println(valorPagar);
	}System.out.println(valorPagar);
}
}



