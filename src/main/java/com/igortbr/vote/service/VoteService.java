package com.igortbr.vote.service;

import java.util.Map;

import com.igortbr.vote.dtos.VoteDTO;

public interface VoteService {
	void create(VoteDTO voteDTO);
	Map<String, Long> findByTopicId(String id);
}
