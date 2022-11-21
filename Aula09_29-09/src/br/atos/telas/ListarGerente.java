package br.atos.telas;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.atos.model.Gerente;
import br.atos.telas.controleTelas.ListarGerenteControle;

public class ListarGerente {

	public void apresentarLista(List<Gerente> listaGerentes, JFrame frameMenuInicial) {

		int quantidadeLinhas = listaGerentes.size();
		int quantidadeDeColunas = 6;

		String[][] tabelaString = new String[quantidadeLinhas][quantidadeDeColunas];

		int posicaoLinha = 0;
		int posicaoColuna = 0;

		for (Gerente gerente : listaGerentes) {

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

		panelListarGerente.add(scrollPaneTabela);

		frameListarGerente.add(panelListarGerente);
		frameListarGerente.setVisible(true);

		JButton botaoVoltar = new JButton("Menu Inicial");
		panelListarGerente.add(botaoVoltar);

		ListarGerenteControle listarGerenteControle = new ListarGerenteControle(frameMenuInicial, frameListarGerente);
		botaoVoltar.addActionListener(listarGerenteControle);

	}

}
