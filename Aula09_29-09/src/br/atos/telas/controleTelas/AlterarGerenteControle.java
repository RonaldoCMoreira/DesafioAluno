package br.atos.telas.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.model.Endereco;
import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioGerente;
import br.atos.validacao.ValidarFormulario;

public class AlterarGerenteControle implements ActionListener {

	JFrame frameTelaAlterar;
	JFrame frameMenuInicial;

	JTextField nomeTextField;
	JTextField cpfTextField;
	JTextField regionalTextField;
	JTextField estadoTextField;
	JTextField ruaTextField;
	JTextField numeroTextField;

	RepositorioGerente repositorioGerente;
	Gerente gerenteAtual;

	boolean validaAlterar;

	public AlterarGerenteControle(JFrame frameTelaAlterar, JFrame frameMenuInicial, JTextField nomeTextField,
			JTextField cpfTextField, JTextField regionalTextField, JTextField estadoTextField, JTextField ruaTextField,
			JTextField numeroTextField, RepositorioGerente repositorioGerente, Gerente gerenteAtual) {
		super();
		this.frameTelaAlterar = frameTelaAlterar;
		this.frameMenuInicial = frameMenuInicial;
		this.nomeTextField = nomeTextField;
		this.cpfTextField = cpfTextField;
		this.regionalTextField = regionalTextField;
		this.estadoTextField = estadoTextField;
		this.ruaTextField = ruaTextField;
		this.numeroTextField = numeroTextField;
		this.repositorioGerente = repositorioGerente;
		this.gerenteAtual = gerenteAtual;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		acionarAlterar();
		frameMenuInicial.setVisible(true);
		frameTelaAlterar.setVisible(false);

	}

	private void acionarAlterar() {
		String msgErro = null;
		ValidarFormulario validarFormulario = new ValidarFormulario();
		Gerente gerenteNovo = new Gerente();
		Endereco endereco = new Endereco();

		gerenteNovo.setNome(nomeTextField.getText());
		gerenteNovo.setCpf(cpfTextField.getText());
		gerenteNovo.setRegional(regionalTextField.getText());
		endereco.setEstado(estadoTextField.getText());
		endereco.setRua(ruaTextField.getText());
		endereco.setNumero(numeroTextField.getText());
		gerenteNovo.setEndereco(endereco);

		msgErro = validarFormulario.validarGerente(gerenteNovo, repositorioGerente, "Alterar");

		if (msgErro == null) {
			validaAlterar = repositorioGerente.alterarGerente(gerenteAtual, gerenteNovo);

			if (validaAlterar) {
				JOptionPane.showMessageDialog(null, gerenteNovo.getNome() + "Foi Alterado!!");
			} else {
				JOptionPane.showMessageDialog(null, "Erro na Alteracao!!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "CPF Invalido!!");
		}
	}

}
