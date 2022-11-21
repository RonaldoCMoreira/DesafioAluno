package br.atos.validacao;

import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioGerente;

public class ValidarFormulario {

	public ValidarFormulario() {
		// TODO Auto-generated constructor stub
	}

	public String validarGerente(Gerente gerente, RepositorioGerente repositorioGerente, String tipoValidacao) {
		String msgErro = null;

		if (tipoValidacao.equals("Cadastrar")) {
			if ((repositorioGerente.buscarGerente(gerente.getCpf()) != null)) {

				msgErro = "Cpf Repetido";
				return msgErro;
			}
		}
		if (!(gerente.getCpf().length() == 5)) {
			msgErro = "CPF nao possui 5 caracteres";
			return msgErro;
		}
		return null;
	}

}
