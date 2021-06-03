package io.springboot.pratice.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<String> TypeMismatchException(MethodArgumentTypeMismatchException tyepemismatchException)
	{
		return new ResponseEntity<String>("No such http request",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> messageNotReadableException(HttpMessageNotReadableException ex)
	{
		return new ResponseEntity<String>("Required request body is missing",HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> notValidException(MethodArgumentNotValidException exception)
	{
		return new ResponseEntity<String>("Validation Error :"+ exception.getBindingResult().getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exception(Exception ex)
	{
		return new ResponseEntity<String>(ex.toString(),HttpStatus.BAD_GATEWAY);
	}
}
