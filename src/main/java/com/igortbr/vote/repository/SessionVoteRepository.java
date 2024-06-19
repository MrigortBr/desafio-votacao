package com.igortbr.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igortbr.vote.model.SessionVote;

@Repository
public interface SessionVoteRepository extends JpaRepository<SessionVote, Long> {

	SessionVote findByIdTopic(Long id);

}
