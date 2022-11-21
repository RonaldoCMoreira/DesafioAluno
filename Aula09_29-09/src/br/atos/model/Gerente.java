package br.atos.model;

public class Gerente extends Funcionario {

	private String regional;
	private Double metaRegional;

	public Gerente() {
		// TODO Auto-generated constructor stub
	}

	public String getRegional() {
		return regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

	public Double getMetaRegional() {
		return metaRegional;
	}

	public void setMetaRegional(Double metaRegional) {
		this.metaRegional = metaRegional;
	}


	// O salario do gerente é de R$60 a hora e tem um desconto de 15% de imposto
	@Override
	public Double calculaSalario(Double horasTrabalhadas) {
		return 60 * horasTrabalhadas * 0.85;
	}
}
