
public class Escola {

	public Escola() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Aluno aluno = new Aluno("testeCpfAluno", "testeNomeAluno");
		aluno.setAdvertencia("testeAdvertencia");
		aluno.setTurma("testeTurma");
		
		System.out.println("CpfAluno: " + aluno.getCpf());
		System.out.println("NomeAluno: " + aluno.getNome());
		System.out.println("Advertencia: " + aluno.getAdvertencia());
		System.out.println("Turma: " + aluno.getTurma());
		
		Professor professor = new Professor("testeCpfprofessor", "testeNomeProfessor");
		professor.setDisciplina("testeDisciplina");
		professor.setSalario(Double.parseDouble("5000.98"));
		
		System.out.println("CpfProfessor: " + professor.getCpf());
		System.out.println("NomeProfessor: " + professor.getNome());
		System.out.println("Disciplina: " + professor.getDisciplina());
		System.out.println("Salario: " + professor.getSalario());
		

	}

}
