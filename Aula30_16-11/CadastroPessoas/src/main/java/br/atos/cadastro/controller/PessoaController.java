package br.atos.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.atos.cadastro.model.Pessoa;
import br.atos.cadastro.repository.PessoaRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;

	@GetMapping("/pessoas")
	public List<Pessoa> listarPessoa() {

		List<Pessoa> pessoas = pessoaRepository.findAll();
		return pessoas;
	}

	@PostMapping("/cadastrarPessoa")
	public void cadastrarPessoa(@RequestBody Pessoa pessoa) {

		pessoaRepository.save(pessoa);
	}

	@GetMapping(value = "/pessoa/{id}")
	public Pessoa buscarPessoa(@PathVariable long id) {

		Pessoa pessoa = pessoaRepository.findById(id);

		return pessoa;
	}

	@DeleteMapping(value = "/pessoaDelete/{id}")
	public ResponseEntity<Void> deletarPessoa(@PathVariable long id) {

		Pessoa pessoa = pessoaRepository.findById(id);
		pessoaRepository.delete(pessoa);
		
		return ResponseEntity.noContent().build();

	}

	@PutMapping("/editarPessoa")
	public void editarPessoa(@RequestBody Pessoa pessoa) {

		pessoaRepository.save(pessoa);
	}

}
