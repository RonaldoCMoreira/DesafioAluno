package br.atos.cadastro.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.atos.cadastro.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
	Optional<User> findByUserName(String userName);

}
