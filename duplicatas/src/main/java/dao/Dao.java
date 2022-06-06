package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {	
	// Objetivo de conexao com o banco de dados
	Connection con;
	// Executar as query (insert,....)
	PreparedStatement stmt;
	// Manipular a consulta (objeto de resposta)
	ResultSet rs;
	
	//URL de conexao com o banco
	private final String URL = "jdbc:mysql://localhost:3306/cadastroduplicata";
	private final String USER = "root"; // Usuario banco
	private final String PASS = ""; // Senha do banco
	
	protected void open()throws Exception {
		//Carregar o driver de conexao
		Class.forName("com.mysql.jdbc.Driver");
		//Abrir a conexao com o banco		
		con= DriverManager.getConnection(URL,USER,PASS);
	}	

	protected void close()throws Exception {
		//Fechar a conexao
		con.close();
		
	}
	
	
	public static void main(String[] args) {
		try {
			//ok...
			Dao d = new Dao();
			d.open();
			d.close();
			System.out.println("ok...");
		} catch (Exception e) {
			// deu ruim...
			e.printStackTrace();	
			}
		
		
	}
	
	
	}