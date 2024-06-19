package com.igortbr.vote.dtos;

import java.time.LocalDateTime;

import com.igortbr.vote.model.Topic;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SessionVoteDTO {
    private String id;
    private String idTopic;
    private Topic topic;
    private LocalDateTime sessionStart;
    private LocalDateTime sessionEnd;
}
