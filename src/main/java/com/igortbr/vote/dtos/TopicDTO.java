package com.igortbr.vote.dtos;


import java.util.Map;

import com.igortbr.vote.enums.TypeStatus;
import com.igortbr.vote.model.Topic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TopicDTO {
	private String id;
	private String name;
	private String content;	
	private TypeStatus status;
	private Map<String, Long> votes;
	
	
	public TopicDTO(Topic topic,  TypeStatus status) {
		this.id = topic.getId().toString();
		this.name = topic.getName();
		this.content = topic.getContent();
		this.status = status;
	}
}
