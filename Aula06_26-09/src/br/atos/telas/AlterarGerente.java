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

	public void alterarGerente(JFrame frameMenuInicial, RepositorioGerente repositorioGerente, Gerente GerenteAtual) {

		// Strings que serão usadas na Label
		String nomeTexto = "Digite o nome do progrador:";
		String cpfTexto = "Digite o CPF:";
		String regionalTexto = "Digite o Regional:";

		// Criação do Frame (Janela)
		JFrame frameTelaAlterar = new JFrame();
		frameTelaAlterar.setSize(200, 300);
		frameTelaAlterar.setTitle("Inserir Gerente");
		frameTelaAlterar.setLocation(300, 300);

		// Criação do painel
		JPanel painelTelaAlterar = new JPanel();

		// Criação da Labels
		JLabel nomeTextoLabel = new JLabel(nomeTexto);
		painelTelaAlterar.add(nomeTextoLabel);

		// Criação da Caixa de texto
		JTextField nomeTextField = new JTextField(10);
		nomeTextField.setText(GerenteAtual.getNome());
		painelTelaAlterar.add(nomeTextField);

		JLabel cpfTextoLabel = new JLabel(cpfTexto);
		painelTelaAlterar.add(cpfTextoLabel);

		JTextField cpfTextField = new JTextField(10);
		cpfTextField.setText(GerenteAtual.getCpf());
		painelTelaAlterar.add(cpfTextField);

		JLabel regionalTextoLabel = new JLabel(regionalTexto);
		painelTelaAlterar.add(regionalTextoLabel);

		JTextField regionalTextField = new JTextField(10);
		regionalTextField.setText(GerenteAtual.getRegional());
		painelTelaAlterar.add(regionalTextField);

		// Criação do botão
		JButton botaoAlterar = new JButton("Alterar");
		painelTelaAlterar.add(botaoAlterar);

		// Adiciona o painel "dentro" do frame(janela)
		frameTelaAlterar.add(painelTelaAlterar);

		// Habilitar visibilidade do frame(janela)
		frameTelaAlterar.setVisible(true);

		AlterarGerenteControle alterarControle = new AlterarGerenteControle(frameTelaAlterar, frameMenuInicial,
				nomeTextField, cpfTextField, regionalTextField, repositorioGerente, GerenteAtual);
		botaoAlterar.addActionListener(alterarControle);

	}

}
