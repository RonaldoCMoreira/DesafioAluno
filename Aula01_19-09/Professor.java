
public class Professor extends Pessoa {

	private String disciplina;
	private Double salario;

	public Professor(String _cpf, String _nome) {
		super(_cpf, _nome);
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
