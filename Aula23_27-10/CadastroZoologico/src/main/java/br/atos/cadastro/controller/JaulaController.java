package br.atos.cadastro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.atos.cadastro.model.Cuidador;
import br.atos.cadastro.model.Jaula;
import br.atos.cadastro.repository.CuidadorRepository;
import br.atos.cadastro.repository.JaulaRepository;

@Controller
public class JaulaController {

	@Autowired
	JaulaRepository jaulaRepository;

	@Autowired
	CuidadorRepository cuidadorRepository;

	// Acessa a pagina de cadastrar a Jaula
	@RequestMapping(value = "/cadastrarJaula", method = RequestMethod.GET) // Direciona o usuario para a pagina
																			// cadastroJaulaHtml.html
	public ModelAndView cadastroJaula() {
		ModelAndView cuidadoresModelAndView = new ModelAndView("cadastroJaulaHtml");
		Iterable<Cuidador> cuidadores = cuidadorRepository.findAll();
		cuidadoresModelAndView.addObject("cuidadores", cuidadores);// Adiciona a lista de cuidadores no objeto
																	// "ModelAndView";

		return cuidadoresModelAndView;
	}

	// Metodo POST acionado pelo formulario de cadastrar uma nova Jaula
	@RequestMapping(value = "/cadastrarJaula", method = RequestMethod.POST) // Metodo post que recebe a entidade
	public String cadastroJaula(Jaula jaula) {
		jaulaRepository.save(jaula);
		return "redirect:/jaulasTabela";
	}

	// Responsavel por direcionar e listar todos as jaulas que foram encontradas
	@RequestMapping(value = "/jaulasTabela", method = RequestMethod.GET) // Metodo get que envia a lista de jaulas
	public ModelAndView listarJaulas() {
		ModelAndView jaulaModelAndView = new ModelAndView("listarJaulasHtml");
		Iterable<Jaula> jaulas = jaulaRepository.findAll();
		jaulaModelAndView.addObject("jaulas", jaulas);// Adiciona a lista de jaulas no objeto "ModelAndView";

		return jaulaModelAndView;

	}

	// Responsavel por deletar uma jaula com base no ID que est?? sendo enviado no
	// PATH (URL)
	@RequestMapping(value = "/deletarJaula/{id}", method = RequestMethod.GET)
	public String deletarJaulaMetodo(@PathVariable("id") long idReq) {
		Jaula jaula = jaulaRepository.findById(idReq);
		jaulaRepository.delete(jaula);

		return "redirect:/jaulasTabela";
	}

	// Responsavel por direcionar o usuario para o formulario de edi????o que j?? esta
	// preenchido com os dados da jaula selecionada
	@RequestMapping(value = "/editarJaula/{id}", method = RequestMethod.GET)
	public ModelAndView editarJaulaMetodo(@PathVariable("id") long idReq) {
		Jaula jaula = jaulaRepository.findById(idReq);

		ModelAndView jaulaAndView = new ModelAndView("editarJaula");
		jaulaAndView.addObject("jaula", jaula);

		return jaulaAndView;
	}

	// Metodo post responsavel por realizar a altera????o da jaula e o mesmo ??
	// acionado no action do formumlario da pagina editar.
	@PostMapping(value = "/editarJaula")
	public String atualizarJaula(Jaula jaula) {
		// long id = jaula.getId();
		jaulaRepository.save(jaula);

		return "redirect:/jaulasTabela";

	}

}
