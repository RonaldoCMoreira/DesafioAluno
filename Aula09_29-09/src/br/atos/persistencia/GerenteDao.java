package br.atos.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.atos.model.Endereco;
import br.atos.model.Gerente;

public class GerenteDao {

	public boolean salvar(Gerente gerente) {

		String sql = "INSERT INTO gerente (cpf, nome, regional, estado, rua, numero) VALUES (?, ?, ?, ?, ?, ?)";
		boolean validaSalvar = false;

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = FabricaConexao.criarConexaocomMySql();
			stmt = (PreparedStatement) con.prepareStatement(sql);

			stmt.setString(1, gerente.getCpf());
			stmt.setString(2, gerente.getNome());
			stmt.setString(3, gerente.getRegional());
			stmt.setString(4, gerente.getEndereco().getEstado());
			stmt.setString(5, gerente.getEndereco().getRua());
			stmt.setString(6, gerente.getEndereco().getNumero());

			stmt.execute();

			System.out.println("Cadastrado com sucesso!!");

			validaSalvar = true;

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

		return validaSalvar;

	}

	public List<Gerente> listar() {

		String sql = "SELECT * FROM gerente";
		List<Gerente> listarGerentes = new ArrayList<>();

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;

		try {
			con = FabricaConexao.criarConexaocomMySql();
			stmt = con.prepareStatement(sql);
			resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				Gerente gerente = new Gerente();
				Endereco endereco = new Endereco();

				gerente.setCpf(resultSet.getString("cpf"));
				gerente.setNome(resultSet.getString("nome"));
				gerente.setRegional(resultSet.getString("regional"));

				endereco.setEstado(resultSet.getString("estado"));
				endereco.setRua(resultSet.getString("rua"));
				endereco.setNumero(resultSet.getString("numero"));

				gerente.setEndereco(endereco);
				listarGerentes.add(gerente);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao listar!!");
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

		return listarGerentes;

	}

	public Gerente select(String cpf) {

		String sql = "SELECT * FROM gerente WHERE cpf = ?";
		Gerente gerente = null;
		Endereco endereco = null;

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;

		try {
			con = FabricaConexao.criarConexaocomMySql();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				gerente = new Gerente();
				endereco = new Endereco();
				gerente.setCpf(resultSet.getString("cpf"));
				gerente.setNome(resultSet.getString("nome"));
				gerente.setRegional(resultSet.getString("regional"));

				endereco.setEstado(resultSet.getString("estado"));
				endereco.setRua(resultSet.getString("rua"));
				endereco.setNumero(resultSet.getString("numero"));

				gerente.setEndereco(endereco);
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

		return gerente;

	}

	public boolean alterar(Gerente gerenteAtual, Gerente gerenteNovo) {

		String sql = "UPDATE gerente SET cpf = ?, nome = ?, regional = ?, estado = ?, rua = ?, numero = ? WHERE cpf = ?";
		boolean validaAlterar = false;

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = FabricaConexao.criarConexaocomMySql();
			stmt = con.prepareStatement(sql);

			stmt.setString(1, gerenteNovo.getCpf());
			stmt.setString(2, gerenteNovo.getNome());
			stmt.setString(3, gerenteNovo.getRegional());
			stmt.setString(4, gerenteNovo.getEndereco().getEstado());
			stmt.setString(5, gerenteNovo.getEndereco().getRua());
			stmt.setString(6, gerenteNovo.getEndereco().getNumero());
			stmt.setString(7, gerenteAtual.getCpf());

			stmt.executeUpdate();

			validaAlterar = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao atualizar!!");
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

		return validaAlterar;

	}

	public boolean deletar(String cpf) {
		String sql = "DELETE FROM gerente WHERE cpf = ?";
		boolean validaDeletar = false;

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = FabricaConexao.criarConexaocomMySql();
			stmt = con.prepareStatement(sql);

			stmt.setString(1, cpf);

			stmt.executeUpdate();

			validaDeletar = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao deletar!!");
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

		return validaDeletar;
	}
}
