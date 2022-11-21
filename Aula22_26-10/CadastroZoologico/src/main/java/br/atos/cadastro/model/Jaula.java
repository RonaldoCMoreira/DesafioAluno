package br.atos.cadastro.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Jaula")
public class Jaula implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idJaula;

	private String nomeZoologico;
	private String bloco;
	private int numeroDaJaula;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TB_CUIDADOR_JAULA", joinColumns = { @JoinColumn(name = "cuidador_id") }, inverseJoinColumns = {
			@JoinColumn(name = "jaula_id") })
	private List<Cuidador> cuidadores;

	public long getIdJaula() {
		return idJaula;
	}

	public void setIdJaula(long idJaula) {
		this.idJaula = idJaula;
	}

	public String getNomeZoologico() {
		return nomeZoologico;
	}

	public void setNomeZoologico(String nomeZoologico) {
		this.nomeZoologico = nomeZoologico;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public int getNumeroDaJaula() {
		return numeroDaJaula;
	}

	public void setNumeroDaJaula(int numeroDaJaula) {
		this.numeroDaJaula = numeroDaJaula;
	}

	public List<Cuidador> getCuidadores() {
		return cuidadores;
	}

	public void setCuidadores(List<Cuidador> cuidadores) {
		this.cuidadores = cuidadores;
	}

}
