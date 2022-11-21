package br.atos.cadastro.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Cuidador")
public class Cuidador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCuidador;
	private String nome;
	private String matricula;

	@ManyToMany(mappedBy = "cuidadores")
	private List<Jaula> jaulas;

	public long getIdCuidador() {
		return idCuidador;
	}

	public void setIdCuidador(long idCuidador) {
		this.idCuidador = idCuidador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Jaula> getJaulas() {
		return jaulas;
	}

	public void setJaulas(List<Jaula> jaulas) {
		this.jaulas = jaulas;
	}

}
