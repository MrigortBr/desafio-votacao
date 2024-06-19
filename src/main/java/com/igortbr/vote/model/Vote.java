package com.igortbr.vote.model;


import com.igortbr.vote.dtos.VoteDTO;
import com.igortbr.vote.enums.TypeVote;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vote")
@NoArgsConstructor
@Getter
public class Vote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(targetEntity = Topic.class)
	@JoinColumn(name = "id_topic", nullable = false)
	private Topic topic;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "id_user", nullable = false)
	private User user;
	
	@Column(name = "type_vote", nullable = false)
	@Enumerated(EnumType.STRING)
	private TypeVote typeVote;
	
	public Vote(VoteDTO voteDTO) {
		this.topic = voteDTO.getTopic();
		this.user = voteDTO.getUser();
		this.typeVote = voteDTO.getTypeVote();
	}
	

}