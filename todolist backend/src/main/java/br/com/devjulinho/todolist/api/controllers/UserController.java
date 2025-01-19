package br.com.devjulinho.todolist.api.controllers;

import br.com.devjulinho.todolist.api.dto.UserCreateDTO;
import br.com.devjulinho.todolist.api.dto.UserDTO;
import br.com.devjulinho.todolist.domain.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    public final UserService service;
    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserCreateDTO dto){
        return new ResponseEntity<UserDTO>(service.createUser(dto), HttpStatus.CREATED);
    }

}
