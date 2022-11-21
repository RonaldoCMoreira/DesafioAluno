package br.atos.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.atos.model.Gerente;

public class RepositorioGerente implements InterfaceRepositorioGerente {

	List<Gerente> listaGerentes = new ArrayList<>();

	@Override
	public boolean salvarGerente(Gerente Gerente) {

		try {
			listaGerentes.add(Gerente);

		} catch (Exception e) {
			System.out.println("Deu erro no cadastro" + e);
			return false;
		}

		return true;
	}

	@Override
	public List<Gerente> listarGerente() {
		// TODO Auto-generated method stub
		return listaGerentes;
	}

	@Override
	public boolean deletarGerente(String cpf) {

		for (Gerente gerente : listaGerentes) {
			// Verificar se vai funcionar
			if (gerente.getCpf().equals(cpf)) {

				listaGerentes.remove(gerente);
				return true;
			}

		}

		return false;
	}

	@Override
	public Gerente buscarGerente(String cpf) {

		for (Gerente gerente : listaGerentes) {
			if (gerente.getCpf().equals(cpf)) {
				return gerente;

			}

		}

		return null;
	}

	@Override
	public boolean alterarGerente(Gerente gerenteAtual, Gerente gerenteNovo) {

		for (Gerente gerente : listaGerentes) {
			if (gerente == gerenteAtual) {
				listaGerentes.remove(gerenteAtual);
				listaGerentes.add(gerenteNovo);
				return true;

			}

		}

		return false;
	}
}
