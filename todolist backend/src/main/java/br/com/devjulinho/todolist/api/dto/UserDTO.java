package br.com.devjulinho.todolist.api.dto;

import br.com.devjulinho.todolist.domain.entities.User;
import br.com.devjulinho.todolist.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;

public class UserDTO {
    Long id;
    String email;

    public UserDTO(){}

    public UserDTO(User user){
        this.id = user.getId();
        this.email = user.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
