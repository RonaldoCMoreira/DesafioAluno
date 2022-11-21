package br.atos.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CadastroZoologicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroZoologicoApplication.class, args);
		
		System.out.println(new BCryptPasswordEncoder().encode("Senha"));
	}

}
