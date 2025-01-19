package br.com.devjulinho.todolist.domain.services;

import br.com.devjulinho.todolist.domain.entities.User;
import br.com.devjulinho.todolist.repository.UserRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;
    public UserDetailsServiceImpl(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User currentUser = repository.findByEmail(email);
        if (currentUser != null) {
            UserDetails user = new org.springframework.security.core.userdetails.User(email, currentUser.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
            return user;
        } else throw new UsernameNotFoundException("Usuário não encontrado!");
    }
}
