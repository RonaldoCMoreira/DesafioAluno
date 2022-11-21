import java.util.Scanner;

import java.util.List;

import java.util.ArrayList;

public class Login {

	public Login() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		String usuarioIn;
		String senhaIn;
		String menuIn = null;
		String subMenuIn = null;

		Scanner entrada = new Scanner(System.in);

		List<Gerente> gerentes = new ArrayList<>();
		List<Coordenador> coordenadores = new ArrayList<>();

		boolean continuar = true;

		System.out.println("Digite o Login:");
		usuarioIn = entrada.next();
		System.out.println("Digite a Senha:");
		senhaIn = entrada.next();

		if (usuarioIn.equals(usuario.getLogin()) && senhaIn.equals(usuario.getSenha())) {
			System.out.println("Login realizado com Sucesso!!!");

			while (continuar) {

				System.out.println("Digite 1 para o Gerente:");
				System.out.println("Digite 2 para o Coordenador:");
				menuIn = entrada.next();

				if (menuIn.equals("1") || menuIn.equals("2")) {
					System.out.println("Opção correta");

					switch (menuIn) {

					case "1":
						Gerente gerente = new Gerente();

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

						gerentes.add(gerente);

						System.out.println("Digite 1 para cadastrar outro Funcionário:");
						System.out.println("Digite 2 para listar os Gerentes:");
						System.out.println("Digite 3 para sair:");
						subMenuIn = entrada.next();

						if (subMenuIn.equals("1") || subMenuIn.equals("2") || subMenuIn.equals("3")) {

							switch (subMenuIn) {

							case "1":
								System.out.println("Menu Principal");
								break;

							case "2":
								for (Gerente gerentesItem : gerentes) {

									System.out.println("Nome do Gerente: " + gerentesItem.getNome());
									System.out.println("Salário Líquido do Gerente: " + gerentesItem.getSalarioLiquido());
									System.out.println("Cpf do Gerente: " + gerentesItem.getCpf());
									System.out.println("Regional do Gerente: " + gerentesItem.getRegional());
									System.out.println("Meta da Regional do Gerente: " + gerentesItem.getMetaRegional());
									System.out.println("################");

								}
								System.out.println("Menu Principal");
								break;

							case "3":
								continuar = false;
								System.out.println("Programa Encerrado!");
								break;
							}

						} else {

							System.out.println("Opcao incorreta");

						}

						break;

					case "2":
						Coordenador coordenador = new Coordenador();

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

						coordenadores.add(coordenador);

						System.out.println("Digite 1 para cadastrar outro Funcionário:");
						System.out.println("Digite 2 para listar os Coordenadores:");
						System.out.println("Digite 3 para sair:");
						subMenuIn = entrada.next();

						if (subMenuIn.equals("1") || subMenuIn.equals("2") || subMenuIn.equals("3")) {

							switch (subMenuIn) {

							case "1":
								System.out.println("Menu Principal");
								break;

							case "2":
								for (Coordenador coordenadoresItem : coordenadores) {

									System.out.println("Nome do Coordenador: " + coordenadoresItem.getNome());
									System.out.println("Salário Líquido do Coordenador: " + coordenadoresItem.getSalarioLiquido());
									System.out.println("Cpf do Coordenador: " + coordenadoresItem.getCpf());
									System.out.println("Loja do Coordenador: " + coordenadoresItem.getLoja());
									System.out.println("Meta da Loja do Coordenador: " + coordenadoresItem.getMetaLoja());
									System.out.println("################");

								}
								System.out.println("Menu Principal");
								break;

							case "3":
								continuar = false;
								System.out.println("Programa Encerrado!");
								break;
							}

						} else {

							System.out.println("Opcao incorreta");

						}

						break;

					}

				} else {

					System.out.println("Opcao incorreta");

				}
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
