package br.atos.telas.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioGerente;

public class CadastrarGerenteControle implements ActionListener {

	JFrame frameTelaCadastro;
	JFrame frameMenuInicial;

	JTextField nomeTextField;
	JTextField cpfTextField;
	JTextField regionalTextField;

	RepositorioGerente repositorioGerente;

	boolean validarSalvar = false;

	public CadastrarGerenteControle(JFrame frameTelaCadastro, JFrame frameMenuInicial, JTextField nomeTextField,
			JTextField cpfTextField, JTextField regionalTextField, RepositorioGerente repositorioGerente) {
		super();
		this.frameTelaCadastro = frameTelaCadastro;
		this.frameMenuInicial = frameMenuInicial;
		this.nomeTextField = nomeTextField;
		this.cpfTextField = cpfTextField;
		this.regionalTextField = regionalTextField;
		this.repositorioGerente = repositorioGerente;
	}

	public CadastrarGerenteControle() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		acionarSalvar();
		frameMenuInicial.setVisible(true);
		frameTelaCadastro.setVisible(false);

	}

	private void acionarSalvar() {
		Gerente gerente = new Gerente();
		gerente.setNome(nomeTextField.getText());
		gerente.setCpf(cpfTextField.getText());
		gerente.setRegional(regionalTextField.getText());

		validarSalvar = repositorioGerente.salvarGerente(gerente);

		if (validarSalvar) {
			JOptionPane.showMessageDialog(null, gerente.getNome() + " Foi Registrado com sucesso!");
			//System.out.println(gerente.getNome() + " Foi Registrado com sucesso!");
		}else {
			JOptionPane.showMessageDialog(null, "Erro ao Cadastrar");
			System.out.println("Erro durante o cadastro");
		}

	}

}
