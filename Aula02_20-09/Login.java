import java.util.Scanner;

public class Login {

	public Login() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		String usuarioIn;
		String senhaIn;
		String menuIn = null;

		Scanner entrada = new Scanner(System.in);
		Gerente gerente = new Gerente();
		Coordenador coordenador = new Coordenador();

		System.out.println("Digite o Login:");
		usuarioIn = entrada.next();
		System.out.println("Digite a Senha:");
		senhaIn = entrada.next();

		if (usuarioIn.equals(usuario.getLogin()) && senhaIn.equals(usuario.getSenha())) {
			System.out.println("Login realizado com Sucesso!!!");
			System.out.println("Digite 1 para o Gerente:");
			System.out.println("Digite 2 para o Coordenador:");
			menuIn = entrada.next();

			if (menuIn.equals("1") || menuIn.equals("2")) {
				System.out.println("Opção correta");

				switch (menuIn) {

				case "1":

					System.out.println("Digite o Nome do Gerente:");
					gerente.setNome(entrada.next());
					System.out.println("Digite as Horas Trabalhadas do Gerente:");
					gerente.setSalarioLiquido(gerente.calculaSalario(Double.parseDouble(entrada.next())));
					System.out.println("Digite o Cpf do Gerente:");
					gerente.setCpf(entrada.next());
					System.out.println("Digite a Regional do Gerente:");
					gerente.setRegional(entrada.next());
					System.out.println("Digite a Meta da Regional do Gerente:");
					gerente.setMetaRegional(Double.parseDouble(entrada.next()));

					System.out.println("Nome do Gerente: " + gerente.getNome());
					System.out.println("Salário Líquido do Gerente: " + gerente.getSalarioLiquido());
					System.out.println("Cpf do Gerente: " + gerente.getCpf());
					System.out.println("Regional do Gerente: " + gerente.getRegional());
					System.out.println("Meta da Regional do Gerente: " + gerente.getMetaRegional());

					break;

				case "2":
					System.out.println("Digite o Nome do Coordenador:");
					coordenador.setNome(entrada.next());
					System.out.println("Digite as Horas Trabalhadas do Coordenador:");
					coordenador.setSalarioLiquido(coordenador.calculaSalario(Double.parseDouble(entrada.next())));
					System.out.println("Digite o Cpf do Coordenador:");
					coordenador.setCpf(entrada.next());
					System.out.println("Digite a Loja do Coordenador:");
					coordenador.setLoja(entrada.next());
					System.out.println("Digite a Meta da Loja do Coordenador:");
					coordenador.setMetaLoja(Double.parseDouble(entrada.next()));

					System.out.println("Nome do Coordenador: " + coordenador.getNome());
					System.out.println("Salário Líquido do Coordenador: " + coordenador.getSalarioLiquido());
					System.out.println("Cpf do Coordenador: " + coordenador.getCpf());
					System.out.println("Loja do Coordenador: " + coordenador.getLoja());
					System.out.println("Meta da Loja do Coordenador: " + coordenador.getMetaLoja());

					break;

				}

			} else {

				System.out.println("Opcao incorreta");

			}

		} else {

			if (usuarioIn.equals(usuario.getLogin()) || senhaIn.equals(usuario.getSenha())) {
				if (usuarioIn.equals(usuario.getLogin())) {
					System.out.println("Login está correto mas a senha está incorreta!!");
				}
				if (senhaIn.equals(usuario.getSenha())) {
					System.out.println("Senha está correta mas o login está incorreto!!");
				}

			} else {
				System.out.println("Login e senha incorretos!!!");

			}

		}

	}

}
