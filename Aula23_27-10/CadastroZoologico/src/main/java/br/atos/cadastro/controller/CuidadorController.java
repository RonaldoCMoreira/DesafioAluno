package br.atos.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.atos.cadastro.model.Cuidador;
import br.atos.cadastro.repository.CuidadorRepository;

@Controller
public class CuidadorController {

	@Autowired
	CuidadorRepository cuidadorRepository;

	// Acessa a pagina de cadastrar a Cuidador
	@RequestMapping(value = "/cadastrarCuidador", method = RequestMethod.GET) // Direciona o usuario para a pagina
																				// cadastroCuidadorHtml.html
	public String cadastroCuidador() {

		return "cadastroCuidadorHtml";
	}

	// Metodo POST acionado pelo formulario de cadastrar um novo Cuidador
	@RequestMapping(value = "/cadastrarCuidador", method = RequestMethod.POST) // Metodo post que recebe a entidade
	public String cadastroCuidador(Cuidador cuidador) {
		cuidadorRepository.save(cuidador);
		return "redirect:/cuidadoresTabela";
	}

	// Responsavel por direcionar e listar todos os cuidadores que foram encontrados
	@RequestMapping(value = "/cuidadoresTabela", method = RequestMethod.GET) // Metodo get que envia a lista de
																				// cuidadores
	public ModelAndView listarCuidadores() {
		ModelAndView cuidadorModelAndView = new ModelAndView("listarCuidadoresHtml");
		Iterable<Cuidador> cuidadores = cuidadorRepository.findAll();
		cuidadorModelAndView.addObject("cuidadores", cuidadores);// Adiciona a lista de cuidadores no objeto
																	// "ModelAndView";

		return cuidadorModelAndView;

	}

	// Responsavel por deletar um cuidador com base no ID que está sendo enviado no
	// PATH (URL)
	@RequestMapping(value = "/deletarCuidador/{id}", method = RequestMethod.GET)
	public String deletarCuidadorMetodo(@PathVariable("id") long idReq) {
		Cuidador cuidador = cuidadorRepository.findById(idReq);
		cuidadorRepository.delete(cuidador);

		return "redirect:/cuidadoresTabela";
	}

	// Responsavel por direcionar o usuario para o formulario de edição que já esta
	// preenchido com os dados do cuidador selecionado
	@RequestMapping(value = "/editarCuidador/{id}", method = RequestMethod.GET)
	public ModelAndView editarCuidadorMetodo(@PathVariable("id") long idReq) {
		Cuidador cuidador = cuidadorRepository.findById(idReq);

		ModelAndView cuidadorAndView = new ModelAndView("editarCuidador");
		cuidadorAndView.addObject("cuidador", cuidador);

		return cuidadorAndView;
	}

	// Metodo post responsavel por realizar a alteração do cuidador e o mesmo é
	// acionado no action do formumlario da pagina editar.
	@PostMapping(value = "/editarCuidador")
	public String atualizarCuidador(Cuidador cuidador) {
		cuidadorRepository.save(cuidador);

		return "redirect:/cuidadoresTabela";

	}

}
