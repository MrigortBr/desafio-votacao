package com.igortbr.vote.exception;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
public class CustomException extends RuntimeException {
	
	private ErrorResponse error;
	
	public CustomException(ErrorResponse error) {
		super("");
		this.error = error;
	}
}
