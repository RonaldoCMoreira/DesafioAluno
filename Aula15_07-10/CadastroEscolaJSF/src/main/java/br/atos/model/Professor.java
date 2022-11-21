package br.atos.model;

public class Professor extends Pessoa {

	private String disciplina;
	private Double salario;

	public Professor() {
		// TODO Auto-generated constructor stub
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

}
