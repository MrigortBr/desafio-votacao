package com.igortbr.vote.dtos;

import com.igortbr.vote.enums.TypeVote;
import com.igortbr.vote.model.Topic;
import com.igortbr.vote.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteDTO {
	private String id;	
	private String idTopic;
	private Topic topic;
	private User user;
	private String idUser;
	private TypeVote typeVote;
}
