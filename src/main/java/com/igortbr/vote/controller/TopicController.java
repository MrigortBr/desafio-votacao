package com.igortbr.vote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igortbr.vote.dtos.TopicDTO;
import com.igortbr.vote.model.Topic;
import com.igortbr.vote.service.TopicService;

@RestController
@RequestMapping(value = "v1/topic", produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
public class TopicController {

	@Autowired
	TopicService service;
	
	@GetMapping
    public ResponseEntity<List<Topic>> listAll() {
        return new ResponseEntity<List<Topic>>(service.listAll(), HttpStatus.OK);
    }
    
    @GetMapping(path = "{id}")
    public ResponseEntity<TopicDTO> listById(@PathVariable String id) {
        return new ResponseEntity<TopicDTO>(service.listById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<String> newTopic(@RequestBody TopicDTO topic) {
    	service.create(topic);
        return new ResponseEntity<>("Novo topico criado com sucesso!",HttpStatus.CREATED);
    }
	
}
