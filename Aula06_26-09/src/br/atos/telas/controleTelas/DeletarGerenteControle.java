package br.atos.telas.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.repositorio.RepositorioGerente;

public class DeletarGerenteControle implements ActionListener {

	JFrame frameListarGerente;
	JFrame menuInicialFrame;
	JTextField cpfField;
	RepositorioGerente repositorioGerente;

	boolean validaDelete;

	public DeletarGerenteControle(JFrame frameListarGerente, JFrame menuInicialFrame, JTextField cpfField,
			RepositorioGerente repositorioGerente) {
		super();
		this.frameListarGerente = frameListarGerente;
		this.menuInicialFrame = menuInicialFrame;
		this.cpfField = cpfField;
		this.repositorioGerente = repositorioGerente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		validaDelete = repositorioGerente.deletarGerente(cpfField.getText());

		if (validaDelete) {
			JOptionPane.showMessageDialog(null, "Gerente excluido com Sucesso");
			menuInicialFrame.setVisible(true);
			frameListarGerente.setVisible(false);

		} else {
			JOptionPane.showMessageDialog(null, "Gerente nao encontrado!!");
			menuInicialFrame.setVisible(true);
			frameListarGerente.setVisible(false);

		}

	}

}
