package br.com.hdsgroup.handsy.services;

import br.com.hdsgroup.handsy.config.security.UserSS;
import br.com.hdsgroup.handsy.entities.UserEntity;
import br.com.hdsgroup.handsy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService { // Implmentando a busca por email e criando o UserDetails

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity usuario = userRepository.findByEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException(email);
        }

        return new UserSS(usuario.getId(), usuario.getEmail(), usuario.getSenha());
    }
}
