package br.atos.telas.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.AlterarGerente;

public class BuscarEditarGerenteControle implements ActionListener {

	JFrame frameListarGerente;
	JFrame frameMenuInicial;
	JTextField cpfField;

	RepositorioGerente repositorioGerente;

	AlterarGerente alterarGerente = new AlterarGerente();

	public BuscarEditarGerenteControle(JFrame frameListarGerente, JFrame frameMenuInicial, JTextField cpfField,
			RepositorioGerente repositorioGerente) {
		super();
		this.frameListarGerente = frameListarGerente;
		this.frameMenuInicial = frameMenuInicial;
		this.cpfField = cpfField;
		this.repositorioGerente = repositorioGerente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Gerente gerenteAtual = new Gerente();

		gerenteAtual = repositorioGerente.buscarGerente(cpfField.getText());

		if (!(gerenteAtual == null)) {
			frameListarGerente.setVisible(false);
			alterarGerente.alterarGerente(frameMenuInicial, repositorioGerente, gerenteAtual);
		} else {
			JOptionPane.showMessageDialog(null, "Digite um CPF de um Gerente da lista de Gerentes!!");
		}

	}

}
