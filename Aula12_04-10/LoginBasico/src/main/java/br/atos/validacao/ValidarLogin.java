package br.atos.validacao;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import br.atos.dataBase.LoginDao;

public class ValidarLogin {

	public ValidarLogin() {
		// TODO Auto-generated constructor stub
	}

	public String validarSenha(String password, String passwordConfirm) {
		String msgErro = null;

		if (!(password.equals(passwordConfirm))) {

			msgErro = "Senha não confere";
			System.out.println("Senha não confere");
			return msgErro;
		}

		return null;
	}

	public String validarUserName(String username, LoginDao loginDao) {
		String msgErro = null;

		if ((loginDao.buscarUserName(username) != null)) {

			msgErro = "UserName Repetido";
			System.out.println("UserName Repetido");
			return msgErro;
		}

		return null;
	}

}
