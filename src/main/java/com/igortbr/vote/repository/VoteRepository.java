package com.igortbr.vote.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igortbr.vote.model.Topic;
import com.igortbr.vote.model.User;
import com.igortbr.vote.model.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long>{

    List<Vote> findByTopicId(Long topicId);

    boolean existsByTopicAndUser(Topic topic, User user);

}
