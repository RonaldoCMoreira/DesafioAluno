package br.atos.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.atos.cadastro.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	Pessoa findById(long id);

	
	
}
