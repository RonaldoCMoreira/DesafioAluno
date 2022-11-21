package br.atos.cadastro.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Indica que é entidade no banco de dados
@Table(name = "TB_Cliente") // Indica o nome da tabela que será inserida no banco
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nome;
	private String cpf;
	private String idade;
	
	/*
	 * @Embedded private Endereco endereco;
	 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	/*
	 * public Endereco getEndereco() { return endereco; }
	 * 
	 * public void setEndereco(Endereco endereco) { this.endereco = endereco; }
	 */

}
