package br.atos.telas;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.atos.model.Gerente;

public class ListarGerente {

	public void apresentarLista(List<Gerente> listaGerentes, JFrame menuInicial) {

		int quantidadeLinhas = listaGerentes.size();

		String[][] tabelaString = new String[quantidadeLinhas][3];

		int posicaoLinha = 0;
		int posicaoColuna = 0;

		for (Gerente gerente : listaGerentes) {

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

		panelListarGerente.add(scrollPaneTabela);

		frameListarGerente.add(panelListarGerente);
		frameListarGerente.setVisible(true);

	}

}
