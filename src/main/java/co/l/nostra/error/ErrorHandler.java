package co.l.nostra.error;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import co.l.nostra.handler.ConstantsGlobal;
import co.l.nostra.handler.DtoHandler;

@ControllerAdvice
public class ErrorHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		//ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		DtoHandler handler = new DtoHandler(ConstantsGlobal.ERROR, ConstantsGlobal.MESSAGE_ERROR, ex.getMessage());
		return new ResponseEntity<>(handler, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		//ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		DtoHandler handler = new DtoHandler(ConstantsGlobal.ERROR, ConstantsGlobal.MESSAGE_ERROR, ex.getMessage());
		return new ResponseEntity<>(handler, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
