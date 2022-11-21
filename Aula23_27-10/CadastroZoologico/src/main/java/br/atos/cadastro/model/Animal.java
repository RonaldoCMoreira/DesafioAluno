package br.atos.cadastro.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Animal")
public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAnimal;
	private String nome;
	private String especie;
	private String raca;
	private Date dataNascimento;

	@ManyToOne
	private Jaula jaula;

	public long getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(long idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Jaula getJaula() {
		return jaula;
	}

	public void setJaula(Jaula jaula) {
		this.jaula = jaula;
	}

}
