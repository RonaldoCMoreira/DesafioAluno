package br.atos.repositorio;

import java.util.List;

import br.atos.model.Gerente;
import br.atos.persistencia.GerenteDao;

public class RepositorioGerente implements InterfaceRepositorioGerente {

	// List<Gerente> listaGerentes = new ArrayList<>();
	GerenteDao dao = new GerenteDao();

	@Override
	public boolean salvarGerente(Gerente gerente) {

		try {
			// listaGerentes.add(gerente);
			dao.salvar(gerente);

		} catch (Exception e) {
			System.out.println("Erro no cadastro!!" + e);
			return false;
		}

		return true;
	}

	@Override
	public List<Gerente> listarGerente() {

		return dao.listar(); // listaGerentes;
	}

	@Override
	public boolean deletarGerente(String cpf) {

		/*for (Gerente gerente : listaGerentes) {
			if (gerente.getCpf().equals(cpf)) {

				listaGerentes.remove(gerente);
				
				return true;
			}
		}*/
		
		try {
			dao.deletar(cpf);
			
		} catch (Exception e) {
			System.out.println("Erro na delecao!!" + e);
			return false;
		}

		return true;
	}

	@Override
	public Gerente buscarGerente(String cpf) {

		/*for (Gerente gerente : listaGerentes) {
			if (gerente.getCpf().equals(cpf)) {
				return gerente;

			}
		}*/
		Gerente gerente = null;
		
		try {
			gerente = dao.select(cpf);
		} catch (Exception e) {
			System.out.println("Erro na selecao!!" + e);
			return null;
		}

		return gerente;
	}

	@Override
	public boolean alterarGerente(Gerente gerenteAtual, Gerente gerenteNovo) {

		/*for (Gerente gerente : dao.listar()  listaGerentes ) {
			if (gerente == gerenteAtual) {
				listaGerentes.remove(gerenteAtual);
				listaGerentes.add(gerenteNovo);
				return true;

			}
		}*/
		
		try {
			dao.alterar(gerenteAtual, gerenteNovo);
			
		} catch (Exception e) {
			System.out.println("Erro na delecao!!" + e);
			return false;
		}
		
		return true;
	}
}
