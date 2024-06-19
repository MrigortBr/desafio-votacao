package com.igortbr.vote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igortbr.vote.dtos.UserDTO;
import com.igortbr.vote.model.User;
import com.igortbr.vote.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@RestController
@RequestMapping(value = "v1/user", produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
public class UserController {


	@Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> listAll() {
        return new ResponseEntity<List<User>>(service.listAll(), HttpStatus.OK);
    }
    
    @GetMapping(path = "{id}")
    public ResponseEntity<User> listById(@PathVariable String id) {
        return new ResponseEntity<User>(service.listById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<String> newUser(@RequestBody UserDTO user) {
    	service.create(user);
        // Retornando uma resposta adequada
        return new ResponseEntity<>("Usuario Criado com sucesso!",HttpStatus.CREATED);
    }
    
    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
    	service.delete(id);
        // Retornando uma resposta adequada
        return new ResponseEntity<>("Usuario deletado com sucesso!",HttpStatus.OK);
    }
    
    @PutMapping(path = "{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserDTO user, @PathVariable String id) {
    	service.update(user, id);
        // Retornando uma resposta adequada
        return new ResponseEntity<>("Usuario atualizado com sucesso!", HttpStatus.CREATED);
    }
}
