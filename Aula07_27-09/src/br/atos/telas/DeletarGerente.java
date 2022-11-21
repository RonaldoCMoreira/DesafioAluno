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

		int quantidadeDeLinhas = repositorioGerente.listarGerente().size();
		int quantidadeDeColunas = 6;

		String stringTextoDeletar = "Digite o cpf que deseja deletar:";

		String[][] tabelaString = new String[quantidadeDeLinhas][quantidadeDeColunas];

		int posicaoLinha = 0;
		int posicaoColuna = 0;

		for (Gerente gerente : repositorioGerente.listarGerente()) {

			tabelaString[posicaoLinha][posicaoColuna] = gerente.getNome();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = gerente.getCpf();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = gerente.getRegional();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = gerente.getEndereco().getEstado();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = gerente.getEndereco().getRua();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = gerente.getEndereco().getNumero();
			posicaoColuna = 0;
			posicaoLinha++;

		}

		String colunasTitulos[] = { "Nome", "Cpf", "Regional", "Estado", "Rua", "Numero" };

		JFrame frameListarGerente = new JFrame();
		frameListarGerente.setSize(500, 600);

		JTable tabelaGerente = new JTable(tabelaString, colunasTitulos);
		tabelaGerente.setBounds(30, 40, 200, 300);

		JScrollPane scrollPaneTabela = new JScrollPane(tabelaGerente);
		JPanel panelListarGerente = new JPanel();

		JLabel stringTextoDeletarLabel = new JLabel(stringTextoDeletar);
		panelListarGerente.add(stringTextoDeletarLabel);

		JTextField cpfTextField = new JTextField(10);
		panelListarGerente.add(cpfTextField);

		JButton botaoDeletar = new JButton("Deletar");
		panelListarGerente.add(botaoDeletar);

		panelListarGerente.add(scrollPaneTabela);

		frameListarGerente.add(panelListarGerente);
		frameListarGerente.setVisible(true);

		DeletarGerenteControle telaDeletarControle = new DeletarGerenteControle(frameListarGerente, menuInicialFrame,
				cpfTextField, repositorioGerente);
		botaoDeletar.addActionListener(telaDeletarControle);
	}

}
