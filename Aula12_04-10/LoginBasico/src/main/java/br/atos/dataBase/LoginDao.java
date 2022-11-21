package br.atos.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.atos.model.LoginEntidade;

public class LoginDao {

	public boolean login(LoginEntidade login) {

		String sql = "SELECT * FROM login WHERE username = ? and password = ?";

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;

		try {
			con = FabricaConexao.criarConexaocomMySql();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, login.getUsername());
			stmt.setString(2, login.getPassword());
			resultSet = stmt.executeQuery();

			return resultSet.next();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao fazer o login!!");
		} finally {
			try {

				if (resultSet != null) {
					resultSet.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("Erro ao encerrrar a conexao!!");
			}

		}

		return false;

	}

	public LoginEntidade buscarUserName(String userName) {

		String sql = "SELECT * FROM login WHERE username = ?";
		LoginEntidade loginEntidade = null;

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;

		try {
			con = FabricaConexao.criarConexaocomMySql();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, userName);
			resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				loginEntidade = new LoginEntidade();
				loginEntidade.setUsername(resultSet.getString("username"));
				loginEntidade.setPassword(resultSet.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao selecionar!!");
		} finally {
			try {

				if (resultSet != null) {
					resultSet.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("Erro ao encerrrar a conexao!!");
			}

		}

		return loginEntidade;

	}

	public boolean inserirUserName(LoginEntidade loginEntidade) {

		String sql = "INSERT INTO login (username, password) VALUES (?, ?)";
		boolean validaInserir = false;

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = FabricaConexao.criarConexaocomMySql();
			stmt = (PreparedStatement) con.prepareStatement(sql);

			stmt.setString(1, loginEntidade.getUsername());
			stmt.setString(2, loginEntidade.getPassword());

			stmt.execute();

			System.out.println("Cadastrado com sucesso!!");

			validaInserir = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao cadastrar!!");

		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("Erro ao encerrrar a conexao!!");
			}
		}

		return validaInserir;

	}
}
