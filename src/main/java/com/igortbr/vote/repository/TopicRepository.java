package com.igortbr.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igortbr.vote.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

}
