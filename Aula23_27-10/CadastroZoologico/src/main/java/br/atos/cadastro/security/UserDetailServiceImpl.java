package br.atos.cadastro.security;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.atos.cadastro.model.User;
import br.atos.cadastro.repository.UserRepository;

@Service // Indicar que uma classe de serviço
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

	final UserRepository userRepository;

	public UserDetailServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario não Encontrado" + username));

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true,
				true, true, true, user.getAuthorities());
	}

}
