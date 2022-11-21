package br.atos.validacao;

import br.atos.model.Gerente;

public class ValidarFormulario {

	public ValidarFormulario() {
		// TODO Auto-generated constructor stub
	}

	public String validarGerente(Gerente gerente) {
		if (!(gerente.getCpf().length() == 5)) {
			return "CPF nao possui 5 caracteres";
		}
		return null;
	}

}
