package br.atos.cadastro.repository;

import org.springframework.data.repository.CrudRepository;

import br.atos.cadastro.model.Animal;
import br.atos.cadastro.model.Jaula;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

	Iterable<Animal> findByJaula(Jaula jaula);

	Animal findById(long id);

}
