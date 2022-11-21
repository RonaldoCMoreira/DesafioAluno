package br.atos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.atos.model.Endereco;
import br.atos.model.Professor;

@ManagedBean(name = "professorBean")
@SessionScoped
public class ProfessorMB {

	List<Professor> professores = new ArrayList<>();

	private Professor professor = new Professor();
	private Endereco endereco = new Endereco();

	public String salvarProfessor() {
		
		professor.setEndereco(endereco);

		int valida = professores.indexOf(professor);
		if (valida < 0) {
			professores.add(professor);
		}

		limparProfessor();
		return "";
	}

	/*
	 * private boolean salvarProfessorValidar(Professor professorNovo) {
	 * 
	 * boolean valida = false;
	 * 
	 * for (Professor professorLista : professores) { if (professorLista ==
	 * professorNovo) { valida = true; }
	 * 
	 * } return valida;
	 * 
	 * }
	 */

	// Inicializa o objeto Professor
	private void limparProfessor() {
		this.professor = new Professor();
		this.endereco = new Endereco();

	}

	public String deletarProfessor(Professor professorItem) {

		professores.remove(professorItem);

		return "";

	}

	public String editarProfessor(Professor professorItem) {
		professor = professorItem;
		endereco = professorItem.getEndereco();
		// professores.remove(professorItem);

		return "";

	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
