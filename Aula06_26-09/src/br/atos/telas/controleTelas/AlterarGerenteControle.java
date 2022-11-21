package br.atos.telas.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioGerente;

public class AlterarGerenteControle implements ActionListener {

	JFrame frameTelaAlterar;
	JFrame frameMenuInicial;
	JTextField nomeTextField;
	JTextField cpfTextField;
	JTextField regionalTextField;

	RepositorioGerente repositorioGerente;
	Gerente gerenteAtual;

	boolean validaAlterar;

	public AlterarGerenteControle(JFrame frameTelaAlterar, JFrame frameMenuInicial, JTextField nomeTextField,
			JTextField cpfTextField, JTextField regionalTextField, RepositorioGerente repositorioGerente,
			Gerente gerenteAtual) {
		super();
		this.frameTelaAlterar = frameTelaAlterar;
		this.frameMenuInicial = frameMenuInicial;
		this.nomeTextField = nomeTextField;
		this.cpfTextField = cpfTextField;
		this.regionalTextField = regionalTextField;
		this.repositorioGerente = repositorioGerente;
		this.gerenteAtual = gerenteAtual;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		acionarAlterar();
		frameMenuInicial.setVisible(true);
		frameTelaAlterar.setVisible(false);

	}

	private void acionarAlterar() {
		br.atos.model.Gerente gerenteNovo = new Gerente();

		gerenteNovo.setNome(nomeTextField.getText());
		gerenteNovo.setCpf(cpfTextField.getText());
		gerenteNovo.setRegional(regionalTextField.getText());

		validaAlterar = repositorioGerente.alterarGerente(gerenteAtual, gerenteNovo);

		if (validaAlterar) {
			JOptionPane.showMessageDialog(null, gerenteNovo.getNome() + "Foi Alterado!!");
		} else {
			JOptionPane.showMessageDialog(null, "Erro na Alteracao!!");
		}

	}

}
