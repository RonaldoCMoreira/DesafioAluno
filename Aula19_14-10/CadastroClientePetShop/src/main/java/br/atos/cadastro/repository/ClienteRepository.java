package br.atos.cadastro.repository;

import org.springframework.data.repository.CrudRepository;

import br.atos.cadastro.model.Cliente;
//Implementa os metodos do crdu(create, read, update, delete)

// Interface que implementa os metodos de salvar, alterar, ler  e deletar (CRUD) - Herda os metodos da classe CrudRepository 
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	Cliente findById(long id);
}
