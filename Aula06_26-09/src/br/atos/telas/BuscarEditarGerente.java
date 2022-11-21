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
import br.atos.telas.controleTelas.BuscarEditarGerenteControle;

public class BuscarEditarGerente {

	public void buscarGerente(JFrame menuInicialFrame, RepositorioGerente repositorioGerente) {

		int quantidadeDeLinhas = repositorioGerente.listarGerente().size();
		int quantidadeDeColunas = 3;

		String stringTextoEditar = "Digite o cpf de quem deseja Alterar:";

		String[][] tabelaString = new String[quantidadeDeLinhas][quantidadeDeColunas];

		int posicaoLinha = 0;
		int posicaoColuna = 0;

		for (Gerente gerente : repositorioGerente.listarGerente()) {

			tabelaString[posicaoLinha][posicaoColuna] = gerente.getNome();

			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = gerente.getCpf();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = gerente.getRegional();
			posicaoColuna = 0;
			posicaoLinha++;

		}

		String colunasTitulos[] = { "Nome", "Cpf", "Regional" };

		JFrame frameListarGerente = new JFrame();
		frameListarGerente.setSize(500, 600);

		JTable tabelaGerente = new JTable(tabelaString, colunasTitulos);
		tabelaGerente.setBounds(30, 40, 200, 300);

		JScrollPane scrollPaneTabela = new JScrollPane(tabelaGerente);
		JPanel panelListarGerente = new JPanel();

		JLabel stringTextoAlterarLabel = new JLabel(stringTextoEditar);
		panelListarGerente.add(stringTextoAlterarLabel);

		JTextField cpfTextField = new JTextField(10);
		panelListarGerente.add(cpfTextField);

		JButton botaoAlterar = new JButton("Buscar");
		panelListarGerente.add(botaoAlterar);

		panelListarGerente.add(scrollPaneTabela);

		frameListarGerente.add(panelListarGerente);
		frameListarGerente.setVisible(true);

		BuscarEditarGerenteControle buscarGerenteEditarControle = new BuscarEditarGerenteControle(frameListarGerente,
				menuInicialFrame, cpfTextField, repositorioGerente);
		botaoAlterar.addActionListener(buscarGerenteEditarControle);

	}

}
