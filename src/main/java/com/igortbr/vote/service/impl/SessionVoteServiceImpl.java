package com.igortbr.vote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igortbr.vote.dtos.SessionVoteDTO;
import com.igortbr.vote.exception.CustomException;
import com.igortbr.vote.exception.ErrorResponse;
import com.igortbr.vote.model.SessionVote;
import com.igortbr.vote.repository.SessionVoteRepository;
import com.igortbr.vote.service.SessionVoteService;

@Service
public class SessionVoteServiceImpl implements SessionVoteService{

	@Autowired
	SessionVoteRepository repository;
	
	@Override
	public void create(SessionVoteDTO sessionVoteDTO) {
		SessionVote sessionVote = new SessionVote(sessionVoteDTO);
		repository.save(sessionVote);
	}
	
	@Override
	public List<SessionVote> listAll() {
		List<SessionVote> sessionsVote = repository.findAll();
		return sessionsVote;
	}

	@Override
	public SessionVote listById(String id) {
		SessionVote sessionVote = repository.findById(Long.parseLong(id)).orElseThrow(() -> new CustomException(ErrorResponse.SESSION_ID_NOT_EXISTS));
		return sessionVote;
	}

	@Override
	public SessionVote findByIdTopic(String id) {
		return repository.findByIdTopic(Long.parseLong(id));
	}
	
	



}
