package br.com.devjulinho.todolist.api.dto;

import br.com.devjulinho.todolist.domain.entities.Status;

import java.time.LocalDate;

public class TodoCreateDTO {
    private long idUser;
    private String title;
    private LocalDate deadline;
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
}
