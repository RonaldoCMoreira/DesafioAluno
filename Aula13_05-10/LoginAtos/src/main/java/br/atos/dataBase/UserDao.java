package br.atos.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.atos.model.UserEntity;

public class UserDao {

	public boolean login(UserEntity userEntidade) {

		String sql = "SELECT * FROM usuario WHERE nome = ? and senha = ?";

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;

		try {
			con = ConectionFactory.criarConexaocomMySql();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, userEntidade.getNome());
			stmt.setString(2, userEntidade.getSenha());
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

	public UserEntity findUsuario(String nome) {

		String sql = "SELECT * FROM usuario WHERE nome = ?";
		UserEntity userEntidade = null;

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;

		try {
			con = ConectionFactory.criarConexaocomMySql();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nome);
			resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				userEntidade = new UserEntity();
				userEntidade.setNome(resultSet.getString("nome"));
				userEntidade.setSenha(resultSet.getString("senha"));
				userEntidade.setEmail(resultSet.getString("email"));
				userEntidade.setTelefone(resultSet.getString("telefone"));
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

		return userEntidade;

	}

	public boolean insertUser(UserEntity userEntidade) {

		String sql = "INSERT INTO usuario (nome, senha, email, telefone) VALUES (?, ?, ?, ?)";
		boolean validaInserir = false;

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConectionFactory.criarConexaocomMySql();
			stmt = (PreparedStatement) con.prepareStatement(sql);

			stmt.setString(1, userEntidade.getNome());
			stmt.setString(2, userEntidade.getSenha());
			stmt.setString(3, userEntidade.getEmail());
			stmt.setString(4, userEntidade.getTelefone());

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
