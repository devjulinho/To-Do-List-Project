package br.com.devjulinho.todolist.domain.entities;

import br.com.devjulinho.todolist.api.dto.TodoCreateDTO;
import br.com.devjulinho.todolist.api.dto.TodoUpdateDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_todo")
public class Todo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id; //padrão trabalhar com a classe Long quando trabalha com ID
    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;
    private String title;
    private LocalDate deadline;
    private LocalDate conclusionDate;
    private Status status;

    public Todo(){}

    public Todo(TodoCreateDTO dto){
        this.user = new User(dto.getIdUser());
        this.title = dto.getTitle();
        this.deadline = dto.getDeadline();
        this.status = dto.getStatus();
    }

    public Todo(TodoUpdateDTO dto){
        this.title = dto.getTitle();
        this.deadline = dto.getDeadline();
        this.status = dto.getStatus();
        this.conclusionDate = dto.getConclusionDate();
        this.id = dto.getId(); //necessário?
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public LocalDate getConclusionDate() {
        return conclusionDate;
    }

    public void setConclusionDate(LocalDate conclusionDate) {
        this.conclusionDate = conclusionDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
