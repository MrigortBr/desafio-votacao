package com.igortbr.vote.model;

import java.time.LocalDateTime;

import com.igortbr.vote.dtos.SessionVoteDTO;
import com.igortbr.vote.enums.TypeStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "session_vote")
@NoArgsConstructor
@Setter
@Getter
public class SessionVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_topic", nullable = false, unique = true)
    private Long idTopic;
    
    @Column(name = "session_start", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime sessionStart;

    @Column(name = "session_end", nullable = false, columnDefinition = "DATETIME DEFAULT (CURRENT_TIMESTAMP + INTERVAL 1 MINUTE)")
    private LocalDateTime sessionEnd;
    
    public SessionVote(SessionVoteDTO sessionVoteDTO) {
    	this.idTopic = Long.parseLong(sessionVoteDTO.getIdTopic());
        this.sessionStart = sessionVoteDTO.getSessionStart() != null ? sessionVoteDTO.getSessionStart() : LocalDateTime.now();
        this.sessionEnd = sessionVoteDTO.getSessionEnd() != null ? sessionVoteDTO.getSessionEnd() : this.sessionStart.plusMinutes(1);
    }
    
    public TypeStatus getStatus() {
        LocalDateTime now = LocalDateTime.now();
        if (now.isAfter(sessionStart) && now.isBefore(sessionEnd)) {
            return TypeStatus.ACTIVE;
        } else if (now.isBefore(sessionStart)) {
            return TypeStatus.SCHEDULED;
        } else {
            return TypeStatus.FINISHED;
        }
    }

}