package com.igortbr.vote.model;


import com.igortbr.vote.dtos.TopicDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "topic")
@NoArgsConstructor
@Getter
@Setter
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "content", nullable = true)
	private String content;	
	
	public Topic(TopicDTO topicDTO) {
		this.name = topicDTO.getName();
		this.content = topicDTO.getContent();
	}
}
