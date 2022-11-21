package br.atos.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.controleTelas.DeletarGerenteControle;

public class DeletarGerente {

	public void excluirGerente(JFrame menuInicialFrame, RepositorioGerente repositorioGerente) {

		// Determina a quantidade de linhas da tabela
		int quantidadeDeLinhas = repositorioGerente.listarGerente().size();
		// Determina a quantidade de colunas
		int quantidadeDeColunas = 3;

		String stringTextoDeletar = "Digite o cpf que deseja deletar:";

		// Determina a matrix os itens de linhas e colunas da tabela

		String[][] tabelaString = new String[quantidadeDeLinhas][quantidadeDeColunas];

		int posicaoLinha = 0; // Determina a posicao da coluna
		int posicaoColuna = 0;// Determina a posicao da linha

		// Percorrer todos os itens da lista
		for (Gerente gerente : repositorioGerente.listarGerente()) {

			// Adiciona a String Nome na celula atual de acordo com o valor das
			// variaveis
			// posicao linha e coluna
			tabelaString[posicaoLinha][posicaoColuna] = gerente.getNome();

			posicaoColuna++; // Incrementa a variavel coluna

			tabelaString[posicaoLinha][posicaoColuna] = gerente.getCpf();
			posicaoColuna++;// Incrementa a variavel coluna

			tabelaString[posicaoLinha][posicaoColuna] = gerente.getRegional();
			posicaoColuna = 0;
			posicaoLinha++; // Incrementa a Varivel linha

		}

		// Determina os titulos das coluna da lista
		String colunasTitulos[] = { "Nome", "Cpf", "Regional" };

		// Cria o frame (janela)
		JFrame frameListarGerente = new JFrame();
		frameListarGerente.setSize(500, 600);

		// Cria o objeto do tipo tabela (interface grafica)
		JTable tabelaGerente = new JTable(tabelaString, colunasTitulos);
		tabelaGerente.setBounds(30, 40, 200, 300);

		// Scroll
		JScrollPane scrollPaneTabela = new JScrollPane(tabelaGerente);
		JPanel panelListarGerente = new JPanel();

		JLabel stringTextoDeletarLabel = new JLabel(stringTextoDeletar);
		panelListarGerente.add(stringTextoDeletarLabel);

		JTextField cpfTextField = new JTextField(10);
		panelListarGerente.add(cpfTextField);

		JButton botaoDeletar = new JButton("Deletar");
		panelListarGerente.add(botaoDeletar);

		// Adiciona o scroll pane no painel
		panelListarGerente.add(scrollPaneTabela);

		// Adiciona o painel no frame e habilita a visibilidade do frame
		frameListarGerente.add(panelListarGerente);
		frameListarGerente.setVisible(true);

		DeletarGerenteControle telaDeletarControle = new DeletarGerenteControle(frameListarGerente, menuInicialFrame,
				cpfTextField, repositorioGerente);
		botaoDeletar.addActionListener(telaDeletarControle);
	}

}
