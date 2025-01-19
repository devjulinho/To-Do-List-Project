package br.com.devjulinho.todolist.api.controllers;

import br.com.devjulinho.todolist.api.dto.TodoCreateDTO;
import br.com.devjulinho.todolist.api.dto.TodoDTO;
import br.com.devjulinho.todolist.api.dto.TodoUpdateDTO;
import br.com.devjulinho.todolist.domain.entities.Status;
import br.com.devjulinho.todolist.domain.entities.Todo;
import br.com.devjulinho.todolist.domain.services.TodoService;
import br.com.devjulinho.todolist.repository.TodoRepository;
import org.apache.coyote.Response;
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

    //public TodoController(){}

    @GetMapping
    public ResponseEntity<List<TodoDTO>> listTasks(){
        return new ResponseEntity<List<TodoDTO>>(service.listAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<TodoDTO>> listTasksByUser(@PathVariable("userId") long userId){
        return new ResponseEntity<List<TodoDTO>>(service.listAllTasksByUser(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/{status}")
    public ResponseEntity<List<TodoDTO>> listTasksByUserAndStatus(@PathVariable("userId") long userId, @PathVariable("status")  Status status){
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
    public ResponseEntity<TodoDTO> removeTask(@PathVariable long todoId) throws Exception {
        return new ResponseEntity<TodoDTO>(service.deleteById(todoId), HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{todoId}")
    public ResponseEntity<TodoDTO> conclude(@PathVariable long todoId) throws Exception {
        return new ResponseEntity<TodoDTO>(service.concludeTask(todoId), HttpStatus.OK);
    }
}
