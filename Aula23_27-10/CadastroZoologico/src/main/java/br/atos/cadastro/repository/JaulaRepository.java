package br.atos.cadastro.repository;

import org.springframework.data.repository.CrudRepository;

import br.atos.cadastro.model.Jaula;

public interface JaulaRepository extends CrudRepository<Jaula, Long> {

	Jaula findById(long id);
}
