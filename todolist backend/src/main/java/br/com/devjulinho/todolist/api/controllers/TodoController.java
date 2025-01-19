package br.com.devjulinho.todolist.api.controllers;

import br.com.devjulinho.todolist.api.dto.TodoCreateDTO;
import br.com.devjulinho.todolist.api.dto.TodoDTO;
import br.com.devjulinho.todolist.api.dto.TodoUpdateDTO;
import br.com.devjulinho.todolist.domain.entities.Status;
import br.com.devjulinho.todolist.domain.entities.Todo;
import br.com.devjulinho.todolist.domain.services.TodoService;
import br.com.devjulinho.todolist.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    public TodoService service;

    public TodoController(TodoService service){
        this.service = service;
    }

    public TodoController(){}

    @GetMapping
    public ResponseEntity<?> listTasks(){
        return null;
    }

    @GetMapping("/{userID}")
    public ResponseEntity<List<TodoDTO>> listTasksByUser(@PathVariable long userId){
        return new ResponseEntity<List<TodoDTO>>(service.listAllTasksByUser(userId), HttpStatus.OK);
    }

    @GetMapping("/{userID}/{status}")
    public ResponseEntity<List<TodoDTO>> listTasksByUserAndStatus(@PathVariable long userId, @PathVariable Status status){
        return new ResponseEntity<List<TodoDTO>>(service.listTasksByUserAndStatus(userId, status), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TodoDTO> createTask(@RequestBody TodoCreateDTO todo){
        return new ResponseEntity<TodoDTO>(service.createTask(todo), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TodoDTO> updateTask(@RequestBody TodoUpdateDTO todo) throws Exception{
        return new ResponseEntity<TodoDTO>(service.updateTask(todo), HttpStatus.OK);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<?> removeTask(@PathVariable long todoId){
        return null;
    }

    @PatchMapping
    public ResponseEntity<?> conclude(){
        return null;
    }
}
