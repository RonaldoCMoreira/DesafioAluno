
public class Coordenador extends Funcionario {
	private String loja;
	private Double metaLoja;

	public Coordenador() {
		// TODO Auto-generated constructor stub
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public Double getMetaLoja() {
		return metaLoja;
	}

	public void setMetaLoja(Double metaLoja) {
		this.metaLoja = metaLoja;
	}

	// O salario do coordenador é de R$40 a hora e tem um desconto de 7% de imposto
	@Override
	public Double calculaSalario(Double horasTrabalhadas) {
		return 40 * horasTrabalhadas * 0.93;
	}
}
