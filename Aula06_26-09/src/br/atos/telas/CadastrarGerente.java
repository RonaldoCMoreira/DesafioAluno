package br.atos.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.controleTelas.CadastrarGerenteControle;

public class CadastrarGerente {

	public void registrarGerente(JTextField opcaoMenuJText, JFrame frameMenuInicial,
			RepositorioGerente repositorioGerente) {

		String nomeTexto = "Digite o nome do Gerente:";
		String cpfTexto = "Digite o CPF:";
		String regionalTexto = "Digite o Regional:";

		JFrame frameTelaCadastro = new JFrame();
		frameTelaCadastro.setSize(200, 300);
		frameTelaCadastro.setTitle("Inserir Gerente");
		frameTelaCadastro.setLocation(300, 300);

		JPanel painelTelaCadastro = new JPanel();

		JLabel nomeTextoLabel = new JLabel(nomeTexto);
		painelTelaCadastro.add(nomeTextoLabel);

		JTextField nomeTextField = new JTextField(10);
		painelTelaCadastro.add(nomeTextField);

		JLabel cpfTextoLabel = new JLabel(cpfTexto);
		painelTelaCadastro.add(cpfTextoLabel);

		JTextField cpfTextField = new JTextField(10);
		painelTelaCadastro.add(cpfTextField);

		JLabel regionalTextoLabel = new JLabel(regionalTexto);
		painelTelaCadastro.add(regionalTextoLabel);

		JTextField regionalTextField = new JTextField(10);
		painelTelaCadastro.add(regionalTextField);

		JButton botaoCadastrar = new JButton("Registrar");
		painelTelaCadastro.add(botaoCadastrar);

		frameTelaCadastro.add(painelTelaCadastro);

		frameTelaCadastro.setVisible(true);

		CadastrarGerenteControle cadastrarGerenteControle = new CadastrarGerenteControle(frameTelaCadastro,
				frameMenuInicial, nomeTextField, cpfTextField, regionalTextField, repositorioGerente);
		botaoCadastrar.addActionListener(cadastrarGerenteControle);
	}

}
