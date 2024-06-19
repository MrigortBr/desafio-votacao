package com.igortbr.vote.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
	private String title;
	private HttpStatus codeError;
	private String description;
	
	public static final ErrorResponse USER_ALREADY_VOTED = new ErrorResponse("Usuario ja votou neste topico", HttpStatus.NOT_FOUND, "Não é permitido votar mais de uma vez no mesmo topico");
	public static final ErrorResponse USER_ID_NOT_EXISTS = new ErrorResponse("Usuario não existe", HttpStatus.NOT_FOUND, "O id informado não existe");
	public static final ErrorResponse TOPIC_ID_NOT_EXISTS = new ErrorResponse("Topico não existe", HttpStatus.NOT_FOUND, "O id informado não existe");
	public static final ErrorResponse SESSION_ID_NOT_EXISTS = new ErrorResponse("Sessão não existe", HttpStatus.NOT_FOUND, "O id informado não existe");
	public static final ErrorResponse DATA_INTEGRITY = new ErrorResponse("Dados fornecidos invalidos ou incompletos", HttpStatus.BAD_REQUEST, "Erro de Violação de Integridade de Dados. Por favor, verifique os dados fornecidos");
	public static final ErrorResponse USER_UNABLE_TO_VOTE = new ErrorResponse("UNABLE_TO_VOTE", HttpStatus.NOT_FOUND, "O usuario não tem permissão para votar nesse topico.");
	public static final ErrorResponse SESSION_NOT_OPEN = new ErrorResponse("Topico não aberto", HttpStatus.NOT_FOUND, "Este topico não estão aberto para votações");
	public static final ErrorResponse NUMBER_FORMAT = new ErrorResponse("Id invalido", HttpStatus.NOT_FOUND, "O id enviado nessa requisição é invalido");
	public static final ErrorResponse NO_ENDPOINT = new ErrorResponse("Rota Invalida", HttpStatus.NOT_FOUND, "A Rota solicitada não existe.");
	public static final ErrorResponse NOT_BLANK = new ErrorResponse("Campos vazios", HttpStatus.NOT_FOUND, "Não são permitidos campos vazios.");
}

