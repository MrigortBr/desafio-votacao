package com.igortbr.vote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.igortbr.vote.dtos.TopicDTO;
import com.igortbr.vote.enums.TypeStatus;
import com.igortbr.vote.exception.CustomException;
import com.igortbr.vote.exception.ErrorResponse;
import com.igortbr.vote.model.SessionVote;
import com.igortbr.vote.model.Topic;
import com.igortbr.vote.repository.TopicRepository;
import com.igortbr.vote.service.SessionVoteService;
import com.igortbr.vote.service.TopicService;
import com.igortbr.vote.service.VoteService;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	TopicRepository repository;
	
	@Autowired
	SessionVoteService sessionVoteService;
	
	@Lazy
	@Autowired
	VoteService voteService;
	
	
	public void create(TopicDTO topicDTO) {
		Topic topic = new Topic(topicDTO);
		repository.save(topic);
	}

	public List<Topic> listAll() {
		List<Topic> topics = repository.findAll();
		return topics;
	}

	public TopicDTO listById(String id) {
		SessionVote sessionVote = sessionVoteService.findByIdTopic(id);
		TypeStatus statusSession = TypeStatus.SCHEDULED;
		if (sessionVote != null) statusSession = sessionVote.getStatus();
		
		Topic topic = repository.findById(Long.parseLong(id)).orElseThrow(() -> new CustomException(ErrorResponse.TOPIC_ID_NOT_EXISTS));

		TopicDTO topicDTO = new TopicDTO(topic, statusSession);
		topicDTO.setVotes(voteService.findByTopicId(id));
		return topicDTO;
	}
}
