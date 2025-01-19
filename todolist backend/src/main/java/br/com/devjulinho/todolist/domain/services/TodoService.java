package br.com.devjulinho.todolist.domain.services;

import br.com.devjulinho.todolist.api.dto.TodoCreateDTO;
import br.com.devjulinho.todolist.api.dto.TodoDTO;
import br.com.devjulinho.todolist.api.dto.TodoUpdateDTO;
import br.com.devjulinho.todolist.domain.entities.Status;
import br.com.devjulinho.todolist.domain.entities.User;
import br.com.devjulinho.todolist.repository.TodoRepository;
import br.com.devjulinho.todolist.domain.entities.Todo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    TodoRepository repository;

    public TodoService(TodoRepository repository){
        this.repository = repository;
    }

    public TodoDTO createTask(TodoCreateDTO todo){
        return new TodoDTO(repository.save(new Todo(todo)));
    }

    public List<TodoDTO> listAllTasks(){
        return repository.findAll()
                .stream()
                .map(TodoDTO::new)
                .collect(Collectors.toList());
    }

    public List<TodoDTO> listAllTasksByUser(long userId){
        return repository.findByUser(new User(userId))
                .stream()
                .map(TodoDTO::new)
                .collect(Collectors.toList());
    }

    public List<TodoDTO> listTasksByUserAndStatus(long userId, Status status){
        return repository.findByUserAndStatus(new User(userId), status)
                .stream()
                .map(TodoDTO::new)
                .collect(Collectors.toList());
    }


    public TodoDTO updateTask(TodoUpdateDTO dto) throws Exception{
        Todo exist = repository.findById(dto.getId());
        if (exist != null){
            Todo insert = new Todo(dto);
            insert.setUser(exist.getUser());
            return new TodoDTO(repository.save(insert));
        }
        else throw new Exception("Objeto não encontrado com id:" + dto.getId());
    }

    public TodoDTO concludeTask(long todoId) throws Exception {
        Todo todo = repository.findById(todoId);
        if (todo != null){
            todo.setStatus(Status.valueOf("DONE"));
            return new TodoDTO(repository.save(todo));
        }
        else throw new Exception("A tarefa informada não foi encontrada.");
    }

    public TodoDTO deleteById(long todoId) throws Exception {
        Todo todo = repository.findById(todoId);
        if (todo != null){
            repository.deleteById(todoId);
            return new TodoDTO(todo);
        }
        else throw new Exception("A tarefa informada não foi encontrada.");
    }
}
