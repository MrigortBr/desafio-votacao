package com.igortbr.vote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igortbr.vote.dtos.VoteDTO;
import com.igortbr.vote.service.VoteService;

@Controller
@RequestMapping("v1/vote")
public class VoteController {

	@Autowired
	VoteService service;
	
	@PostMapping
	public ResponseEntity<String> vote(@RequestBody VoteDTO voteDTO){
		service.create(voteDTO);
    	return new ResponseEntity<String>("Voto realizado com sucesso!", HttpStatus.OK);
	}
}
