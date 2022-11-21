package br.atos.repositorio;

import java.util.List;

import br.atos.model.Gerente;

public interface InterfaceRepositorioGerente {

	public boolean salvarGerente(Gerente Gerente);

	public List<Gerente> listarGerente();
	
	
}
