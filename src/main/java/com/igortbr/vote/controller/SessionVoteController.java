package com.igortbr.vote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igortbr.vote.dtos.SessionVoteDTO;
import com.igortbr.vote.model.SessionVote;
import com.igortbr.vote.service.SessionVoteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping(value = "v1/session", produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
public class SessionVoteController {
	
	@Autowired
	SessionVoteService service;
	
	@GetMapping
	public ResponseEntity<List<SessionVote>> listAll(){
        return new ResponseEntity<List<SessionVote>>(service.listAll(), HttpStatus.OK);

	}
	
    @GetMapping(path = "{id}")
    public ResponseEntity<SessionVote> listById(@PathVariable String id){
    	SessionVote session = service.listById(id);
    	return new ResponseEntity<SessionVote>(session, HttpStatus.OK);
    }
	
    @PostMapping
    public ResponseEntity<String> newSession(@RequestBody SessionVoteDTO sessionVoteDTO) {
    	service.create(sessionVoteDTO);
        // Retornando uma resposta adequada
        return new ResponseEntity<>("Sessão de votação criada com sucesso",HttpStatus.CREATED);
    }
    

	
	
	
}
