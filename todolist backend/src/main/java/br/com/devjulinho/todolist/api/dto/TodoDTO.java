package br.com.devjulinho.todolist.api.dto;

import br.com.devjulinho.todolist.domain.entities.Status;
import br.com.devjulinho.todolist.domain.entities.Todo;

import java.time.LocalDate;

public class TodoDTO {
    private long id;
    private long idUser;
    private String title;
    private LocalDate deadline;
    private Status status;

    public TodoDTO(Todo todo){
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.deadline = todo.getDeadline();
        this.status = todo.getStatus();
        this.idUser = todo.getUser().getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
