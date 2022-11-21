package br.atos.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {

	private static String USERNAME = "root";
	private static String PASSWORD = "admin";

	private static String DATABASE_URL = "jdbc:mysql://localhost:3306/banco_teste?useTimezone=true&serverTimezone=UTC";

	public static Connection criarConexaocomMySql() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conexao = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return conexao;

	}

}
