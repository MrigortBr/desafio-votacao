package com.igortbr.vote.service;

import java.util.List;

import com.igortbr.vote.dtos.TopicDTO;
import com.igortbr.vote.model.Topic;

public interface TopicService {
	void create(TopicDTO topicDTO);
	
	List<Topic> listAll();

	TopicDTO listById(String id);	
}
