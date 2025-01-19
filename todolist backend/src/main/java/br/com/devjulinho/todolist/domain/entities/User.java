package br.com.devjulinho.todolist.domain.entities;

import br.com.devjulinho.todolist.api.dto.UserCreateDTO;
import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.util.List;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true, nullable=false)
    private String email;
    private String name;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy="user")
    private List<Todo> todoList;

    public User(){}

    public User(long id){
        this.id = id;
    }

    public User (UserCreateDTO dto){
        this.email = dto.getEmail();
        this.password = dto.getPassword();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }
}
