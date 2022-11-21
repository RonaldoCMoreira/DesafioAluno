package br.atos.model;

public class Funcionario {

	private String nome;
	private Double salarioLiquido;
	private String cpf;
	private Endereco endereco;

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(Double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Double calculaSalario(Double horasTrabalhadas) {
		return 30 * horasTrabalhadas;
	}
}
