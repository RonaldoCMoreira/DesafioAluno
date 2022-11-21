package br.atos.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.telas.controleTelas.MenuInicialControle;

public class MenuInicial {

	public void apresentarMenuInicial() {

		// String opcaoMenu = null;

		String menuInicialTexto = "Menu Inicial";
		String opcaoUmMenuTexto = "[1] Cadastrar Gerente";
		String opcaoDoisMenuTexto = "[2] Listar Gerente";
		String opcaoTresMenuTexto = "[3] Encerrar";
		String opcaoQuatroMenuTexto = "[4] Deletar                          ";
		String opcaoCincoMenuTexto = "[5] Editar                          ";

		JFrame frameMenuInicial = new JFrame();
		frameMenuInicial.setSize(200, 300);
		frameMenuInicial.setTitle("Cadastro de Gerente");
		frameMenuInicial.setLocation(300, 300);

		JPanel panelMenuInicial = new JPanel();

		JLabel menuInicialTextoLabel = new JLabel(menuInicialTexto);
		panelMenuInicial.add(menuInicialTextoLabel);

		JLabel opcaoUmMenuTextoLabel = new JLabel(opcaoUmMenuTexto);
		panelMenuInicial.add(opcaoUmMenuTextoLabel);

		JLabel opcaoDoisMenuTextoLabel = new JLabel(opcaoDoisMenuTexto);
		panelMenuInicial.add(opcaoDoisMenuTextoLabel);

		JLabel opcaoTresMenuTextoLabel = new JLabel(opcaoTresMenuTexto);
		panelMenuInicial.add(opcaoTresMenuTextoLabel);

		JLabel opcaoQuatroMenuTextoLabel = new JLabel(opcaoQuatroMenuTexto);
		panelMenuInicial.add(opcaoQuatroMenuTextoLabel);
		
		JLabel opcaoCincoMenuTextoLabel = new JLabel(opcaoCincoMenuTexto);
		panelMenuInicial.add(opcaoCincoMenuTextoLabel);
		
		JTextField opcaoMenuJTextField = new JTextField(10);
		panelMenuInicial.add(opcaoMenuJTextField);

		JButton botaoMenu = new JButton("Enviar");
		panelMenuInicial.add(botaoMenu);

		frameMenuInicial.add(panelMenuInicial);
		frameMenuInicial.setVisible(true);

		MenuInicialControle menuInicialControle = new MenuInicialControle(opcaoMenuJTextField, frameMenuInicial);

		botaoMenu.addActionListener(menuInicialControle);

	}

}
