package com.igortbr.vote.service;

import java.util.List;

import com.igortbr.vote.dtos.SessionVoteDTO;
import com.igortbr.vote.model.SessionVote;

public interface SessionVoteService {
	void create(SessionVoteDTO sessionVoteDTO);
	
	List<SessionVote> listAll();
	
	SessionVote listById(String id);
	
	SessionVote findByIdTopic(String id);
}
