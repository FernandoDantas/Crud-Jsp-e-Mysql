package br.com.exemplo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exemplo01","root", "");
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro - Conexao"+e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Erro - Dreiver"+e.getMessage());
			e.printStackTrace();
		}return con;
	}
	
}
