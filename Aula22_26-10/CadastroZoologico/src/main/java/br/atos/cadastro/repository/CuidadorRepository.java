package br.atos.cadastro.repository;

import org.springframework.data.repository.CrudRepository;

import br.atos.cadastro.model.Cuidador;
import br.atos.cadastro.model.Jaula;

public interface CuidadorRepository extends CrudRepository<Cuidador, Long> {
	Iterable<Cuidador> findByJaulas(Jaula jaula);

	Cuidador findById(long id);
}
