package br.atos.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.atos.cadastro.model.Pet;
import br.atos.cadastro.model.Cliente;
import br.atos.cadastro.repository.PetRepository;
import br.atos.cadastro.repository.ClienteRepository;

@Controller // Indica que a classe é do tipo controlador
public class ClienteController {

	@Autowired // Inicializa a classe ClienteRepository em todas as chamadas
	ClienteRepository clienteRepository;

	@Autowired // Inicializa a classe PetRepository em todas as chamadas
	PetRepository petRepository;

	// Acessa a pagina de cadastrar o Cliente
	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.GET) // Direciona o usuario para a pagina cadastroClienteHtml.html
	public String cadastroCliente() {

		return "cadastroClienteHtml";
	}

	// Metodo POST acionado pelo formulario de cadastrar um novo Cliente
	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST) // Metodo post que recebe a entidade
	public String cadastroCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		return "redirect:/clientesTabela";
	}

	// Responsavel por direcionar e listar todos os clientes que foram encontrados
	// no banco de dados
	@RequestMapping("/clientesTabela") // Metodo get que envia a lista de clientes
	public ModelAndView listarClientes() {
		ModelAndView clienteModelAndView = new ModelAndView("listarClientesHtml"); // Objeto que recebe o "endereço de
																					// uma pagina HTML" e um ou mais
																					// objetos que também podem ser uma
																					// lista.
		Iterable<Cliente> clientes = clienteRepository.findAll(); // Busca todos clientes no banco de dados
		clienteModelAndView.addObject("clientes", clientes);// Adiciona a lista de clientes no objeto "ModelAndView";

		return clienteModelAndView;

	}

	// Responsavel por deletar um cliente com base no ID que está sendo enviado no
	// PATH (URL)
	@RequestMapping(value = "/deletarCliente/{id}", method = RequestMethod.GET)
	public String deletarClienteMetodo(@PathVariable("id") long idReq) {
		Cliente cliente = clienteRepository.findById(idReq); // Buscar o cliente pelo ID
		clienteRepository.delete(cliente); // Acionar o metodo de deletar da classe CRUD REPOSITORY

		return "redirect:/clientesTabela";
	}

	// Responsavel por direcionar o usuario para o formulario de edição que já esta
	// preenchido com os dados do cliente selecionado
	@RequestMapping(value = "/editarCliente/{id}", method = RequestMethod.GET)
	public ModelAndView editarClienteMetodo(@PathVariable("id") long idReq) {
		Cliente cliente = clienteRepository.findById(idReq);

		ModelAndView clienteAndView = new ModelAndView("editarCliente");
		clienteAndView.addObject("cliente", cliente);

		return clienteAndView;
	}

	// Metodo post responsavel por realizar a alteração do cliente e o mesmo é
	// acionado no action do formumlario da pagina editar.
	@PostMapping(value = "/editar")
	public String atualizarCliente(Cliente cliente) {
		long id = cliente.getId();
		clienteRepository.save(cliente);

		return "redirect:/clientesTabela";

	}

	// Responsavel por direcionar o usuario para a pagina de adiciona um novo pet
	// para o cliente selecionado, enviado todos os pets já registrados e o cliente
	// selecionado
	@RequestMapping(value = "/adicionarPet/{id}", method = RequestMethod.GET)
	public ModelAndView adicionatPetMetodo(@PathVariable("id") long idReq) {
		Cliente cliente = clienteRepository.findById(idReq);
		ModelAndView clienteAndView = new ModelAndView("adicionarPet");
		clienteAndView.addObject("cliente", cliente);

		Iterable<Pet> pets = petRepository.findByCliente(cliente); // Busca todos os pets referentes ao cliente
																	// selecionado.
		clienteAndView.addObject("pets", pets);

		return clienteAndView;

	}

	// Adiciona o pet ao cliente selecionado - O mesmo é acionado no metodo post do
	// formulario da pagina adicionar pet
	@RequestMapping(value = "/adicionarPet/{id}", method = RequestMethod.POST)
	public String adicionaPet(@PathVariable("id") long idReq, Pet pet) {

		Cliente cliente = clienteRepository.findById(idReq);
		pet.setCliente(cliente);
		petRepository.save(pet);

		return "redirect:/adicionarPet/{id}";

	}

}
