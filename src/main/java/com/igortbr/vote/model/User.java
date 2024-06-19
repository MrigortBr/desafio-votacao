package com.igortbr.vote.model;

import com.igortbr.vote.dtos.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter 
@Setter
@NoArgsConstructor
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "cpf", nullable = false)
    @NotBlank
    private String cpf;

	public User(UserDTO user) {
		super();
		this.id = Long.parseLong(user.getId());
		this.name = user.getName();
		this.cpf = user.getCpf();
	}
    
}