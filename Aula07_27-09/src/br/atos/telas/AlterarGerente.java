package br.atos.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.controleTelas.AlterarGerenteControle;

public class AlterarGerente {

	public void alterarGerente(JFrame frameMenuInicial, RepositorioGerente repositorioGerente, Gerente gerenteAtual) {

		String nomeTexto = "Digite o nome do progrador:";
		String cpfTexto = "Digite o CPF:";
		String regionalTexto = "Digite o Regional:";
		String estadoTexto = "Digite o Estado:";
		String ruaTexto = "Digite a Rua:";
		String numeroTexto = "Digite o numero:";

		JFrame frameTelaAlterar = new JFrame();
		frameTelaAlterar.setSize(200, 400);
		frameTelaAlterar.setTitle("Inserir Gerente");
		frameTelaAlterar.setLocation(300, 300);

		JPanel painelTelaAlterar = new JPanel();

		JLabel nomeTextoLabel = new JLabel(nomeTexto);
		painelTelaAlterar.add(nomeTextoLabel);

		JTextField nomeTextField = new JTextField(10);
		nomeTextField.setText(gerenteAtual.getNome());
		painelTelaAlterar.add(nomeTextField);

		JLabel cpfTextoLabel = new JLabel(cpfTexto);
		painelTelaAlterar.add(cpfTextoLabel);

		JTextField cpfTextField = new JTextField(10);
		cpfTextField.setText(gerenteAtual.getCpf());
		painelTelaAlterar.add(cpfTextField);

		JLabel regionalTextoLabel = new JLabel(regionalTexto);
		painelTelaAlterar.add(regionalTextoLabel);

		JTextField regionalTextField = new JTextField(10);
		regionalTextField.setText(gerenteAtual.getRegional());
		painelTelaAlterar.add(regionalTextField);

		JLabel estadoTextoLabel = new JLabel(estadoTexto);
		painelTelaAlterar.add(estadoTextoLabel);

		JTextField estadoTextField = new JTextField(10);
		estadoTextField.setText(gerenteAtual.getEndereco().getEstado());
		painelTelaAlterar.add(estadoTextField);

		JLabel ruaTextoLabel = new JLabel(ruaTexto);
		painelTelaAlterar.add(ruaTextoLabel);

		JTextField ruaTextField = new JTextField(10);
		ruaTextField.setText(gerenteAtual.getEndereco().getRua());
		painelTelaAlterar.add(ruaTextField);

		JLabel numeroTextoLabel = new JLabel(numeroTexto);
		painelTelaAlterar.add(numeroTextoLabel);

		JTextField numeroTextField = new JTextField(10);
		numeroTextField.setText(gerenteAtual.getEndereco().getNumero());
		painelTelaAlterar.add(numeroTextField);

		JButton botaoAlterar = new JButton("Alterar");
		painelTelaAlterar.add(botaoAlterar);

		frameTelaAlterar.add(painelTelaAlterar);

		frameTelaAlterar.setVisible(true);

		AlterarGerenteControle alterarControle = new AlterarGerenteControle(frameTelaAlterar, frameMenuInicial,
				nomeTextField, cpfTextField, regionalTextField, estadoTextField, ruaTextField, numeroTextField,
				repositorioGerente, gerenteAtual);
		botaoAlterar.addActionListener(alterarControle);

	}

}
