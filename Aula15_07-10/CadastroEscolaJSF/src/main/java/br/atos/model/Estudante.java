package br.atos.model;

public class Estudante extends Pessoa {
	private String turma;
	private Double media;

	public Estudante() {
		// TODO Auto-generated constructor stub
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

}
