package br.atos.telas.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ListarGerenteControle implements ActionListener {

	JFrame frameMenuInicial;
	JFrame frameListar;

	public ListarGerenteControle(JFrame frameMenuInicial, JFrame frameListar) {
		super();
		this.frameMenuInicial = frameMenuInicial;
		this.frameListar = frameListar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frameListar.setVisible(false);
		frameMenuInicial.setVisible(true);

	}

}
