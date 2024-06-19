package com.igortbr.vote.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.igortbr.vote.dtos.TopicDTO;
import com.igortbr.vote.dtos.VoteDTO;
import com.igortbr.vote.enums.TypePermission;
import com.igortbr.vote.enums.TypeVote;
import com.igortbr.vote.exception.CustomException;
import com.igortbr.vote.exception.ErrorResponse;
import com.igortbr.vote.repository.VoteRepository;
import com.igortbr.vote.service.TopicService;
import com.igortbr.vote.service.UserService;
import com.igortbr.vote.service.VoteService;
import com.igortbr.vote.model.Topic;
import com.igortbr.vote.model.User;
import com.igortbr.vote.model.Vote;

@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	VoteRepository repository;
	
	@Autowired
	UserService userService;
	
	@Lazy
	@Autowired
	TopicService topicService;
	
	@Autowired
	CPFValidatorImpl cpfValidator;
	

	@Override
	public void create(VoteDTO voteDTO) {
		TopicDTO topicDTO = topicService.listById(voteDTO.getIdTopic());
		Topic topic = new Topic(topicDTO);
		topic.setId(Long.parseLong(topicDTO.getId()));
		
		if (topicDTO.getStatus().name() != "ACTIVE") throw new CustomException(ErrorResponse.SESSION_NOT_OPEN);
		
		User user = userService.listById(voteDTO.getIdUser());

		voteDTO.setUser(user);
		voteDTO.setTopic(topic);
	
		TypePermission canVote = cpfValidator.checkVotingEligibility(user.getCpf());

		
        if (repository.existsByTopicAndUser(topic, user)) throw new CustomException(ErrorResponse.USER_ALREADY_VOTED);	
		if (canVote.name() == "UNABLE_TO_VOTE") throw new CustomException(ErrorResponse.USER_UNABLE_TO_VOTE);
		
		Vote vote = new Vote(voteDTO);
		
		repository.save(vote);
	}

	
	public Map<String, Long> findByTopicId(String id) {
		List<Vote> votes = repository.findByTopicId(Long.parseLong(id));
		Map<String, Long> formattedVotes = formattedVotes(votes);
		return formattedVotes;
	}
	
	public Map<String, Long> formattedVotes(List<Vote> votes){
        Map<String, Long> voteCounts = new HashMap<>();

        voteCounts.put("Total", 0L);

        
        for (TypeVote typeVote : TypeVote.values()) {
            voteCounts.put(typeVote.name(), 0L);
        }
        
        
        for (Vote vote : votes) {
			@SuppressWarnings("unlikely-arg-type")
			Long actualCounts = (voteCounts.get(vote.getTypeVote()) != null) ? voteCounts.get(vote.getTypeVote())+ 1 : 1L;
			voteCounts.put(vote.getTypeVote().name(), actualCounts);
			voteCounts.put("Total", voteCounts.get("Total") + 1L);
		}
		
        
		return voteCounts;
	}
	 
	
	
	


}
