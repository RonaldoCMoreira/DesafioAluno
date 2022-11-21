package br.atos.repositorio;

import java.util.List;

import br.atos.model.Gerente;

public interface InterfaceRepositorioGerente {

	public boolean salvarGerente(Gerente Gerente);

	public List<Gerente> listarGerente();

	public boolean deletarGerente(String cpf);

	public Gerente buscarGerente(String cpf);

	public boolean alterarGerente(Gerente gerenteAtual, Gerente gerenteNovo);
}
