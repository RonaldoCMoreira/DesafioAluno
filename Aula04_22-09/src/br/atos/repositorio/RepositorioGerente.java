package br.atos.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.atos.model.Gerente;

public class RepositorioGerente implements InterfaceRepositorioGerente {

	List<Gerente> listaDeGerentees = new ArrayList<>();

	@Override
	public boolean salvarGerente(Gerente Gerente) {

		try {
			listaDeGerentees.add(Gerente);

		} catch (Exception e) {
			System.out.println("Deu erro no cadastro" + e);
			return false;
		}

		return true;
	}

	@Override
	public List<Gerente> listarGerente() {
		// TODO Auto-generated method stub
		return listaDeGerentees;
	}

}
