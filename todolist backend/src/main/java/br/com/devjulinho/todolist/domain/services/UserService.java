package br.com.devjulinho.todolist.domain.services;

import br.com.devjulinho.todolist.api.dto.UserCreateDTO;
import br.com.devjulinho.todolist.api.dto.UserDTO;
import br.com.devjulinho.todolist.domain.entities.User;
import br.com.devjulinho.todolist.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;

@Service
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO createUser (UserCreateDTO dto) throws DataIntegrityViolationException {
        User user = repository.findByEmail(dto.getEmail());
        if(user != null) throw new DataIntegrityViolationException("Já existe um usuário cadastrado com esse e-mail");
        User newUser = new User(dto);
        newUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        return new UserDTO(repository.save(new User(dto)));
    }


}
