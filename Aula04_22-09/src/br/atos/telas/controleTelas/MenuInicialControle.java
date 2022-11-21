package br.atos.telas.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.ListarGerente;
import br.atos.telas.CadastrarGerente;

public class MenuInicialControle implements ActionListener {

	JTextField opcaoMenuJTextField;
	JFrame frameMenuInicial;

	CadastrarGerente cadastarGerente = new CadastrarGerente();
	ListarGerente listarGerente = new ListarGerente();
	RepositorioGerente repositorioGerente = new RepositorioGerente();

	public MenuInicialControle() {

	}

	public MenuInicialControle(JTextField opcaoMenuJTextFieldCr, JFrame frameMenuInicialCr) {
		this.opcaoMenuJTextField = opcaoMenuJTextFieldCr;
		this.frameMenuInicial = frameMenuInicialCr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (opcaoMenuJTextField.getText().equals("1") || opcaoMenuJTextField.getText().equals("2")
				|| opcaoMenuJTextField.getText().equals("3")) {

			frameMenuInicial.setVisible(false);

			switch (opcaoMenuJTextField.getText()) {
			case "1":
				cadastarGerente.registrarGerente(opcaoMenuJTextField, frameMenuInicial, repositorioGerente);

				System.out.println("Cadastre o Gerente!");
				break;

			case "2":

				listarGerente.apresentarLista(repositorioGerente.listarGerente(), frameMenuInicial);
				System.out.println("Lista Gerente");

				break;

			case "3":
				System.out.println("Voce encerrou");
				break;

			}

		} else {

			System.out.println("Opcao Invalida!!");
		}

	}

}
