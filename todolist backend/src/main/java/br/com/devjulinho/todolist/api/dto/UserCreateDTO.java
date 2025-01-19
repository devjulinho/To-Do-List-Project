package br.com.devjulinho.todolist.api.dto;

import br.com.devjulinho.todolist.domain.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserCreateDTO {
    @NotEmpty
    @Email(message="O e-mail não é válido.")
    String email;
    @Size(min=5, max=25,message="A senha deve ter entre 5 e 25 caracteres.")
    String password;

    public UserCreateDTO(){}

    public UserCreateDTO (User user){
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
