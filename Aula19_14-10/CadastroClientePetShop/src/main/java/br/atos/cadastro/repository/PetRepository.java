package br.atos.cadastro.repository;

import org.springframework.data.repository.CrudRepository;

import br.atos.cadastro.model.Cliente;
import br.atos.cadastro.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

	Iterable<Pet> findByCliente(Cliente cliente);
	Pet findById(long id);
	
}
