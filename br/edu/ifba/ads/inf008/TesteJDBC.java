package br.edu.ifba.ads.inf008;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteJDBC {

	public void run() throws SQLException, ClassNotFoundException {
//		Class.forName("org.h2.Driver");
		DriverManager.registerDriver(new org.hsqldb.jdbcDriver());
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/", "SA", "");
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO ELEMENTAR(id, descricao, duracao) VALUES(?, ?, ?)");
		stmt.setString(1, "elem03");
		stmt.setString(2, "Atividade Elementar 03");
		stmt.setInt(3, 25);
		int linhas = stmt.executeUpdate();
		System.out.println("Linhas afetadas: " + linhas);
		stmt.close();
		conn.close();
	}
	
	public void run2() throws SQLException, ClassNotFoundException {
//		Class.forName("org.h2.Driver");
		DriverManager.registerDriver(new org.hsqldb.jdbcDriver());
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/", "SA", "");
		PreparedStatement stmt = conn.prepareStatement("SELECT id, descricao, duracao FROM ELEMENTAR");
		ResultSet rSet = stmt.executeQuery();
		while(rSet.next())
			System.out.println(rSet.getString("id") + "- " + rSet.getString("descricao") + " / " + rSet.getInt("duracao"));
		rSet.close();
		stmt.close();
		conn.close();
	}	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		(new TesteJDBC()).run2();
		System.out.println("Finalizando...");
	}
	
}
