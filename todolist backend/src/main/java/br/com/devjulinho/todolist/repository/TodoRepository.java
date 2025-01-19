package br.com.devjulinho.todolist.repository;

import br.com.devjulinho.todolist.domain.entities.Status;
import br.com.devjulinho.todolist.domain.entities.Todo;
import br.com.devjulinho.todolist.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
    public Todo save(Todo t);
    public List<Todo> findByUser(User user);
    public List<Todo> findByUserAndStatus(User user, Status status);
    public Todo findById(long id);
}
