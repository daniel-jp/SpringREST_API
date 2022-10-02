package com.springRest.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springRest.api.bexception.BusinessExceptions;
import com.springRest.api.bexception.BusinessNotFoundExeption;

@ControllerAdvice
public class ApiExceptionHendler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Error.Fields> fields = new ArrayList<>();
		
		for (ObjectError objerr: ex.getBindingResult().getAllErrors() ){
			
			String name = ((FieldError) objerr).getField();
			String message = objerr.getDefaultMessage();
			
			fields.add(new Error.Fields(name, message));
			
}
	
					Error err = new Error();
					err.setStatus(status.value());
					err.setDateTime(OffsetDateTime.now());
					err.setTitle("One or more fields are invalid. Do correctly and try again.");
					err.setFields(fields);
		
		return handleExceptionInternal(ex,err, headers, status, request);
	} 
	
	@ExceptionHandler(BusinessNotFoundExeption.class)
	public ResponseEntity<Object> handlerBusinessNotFoundExeption(BusinessNotFoundExeption ex,  WebRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		Error err = new Error();
		err.setStatus(status.value());
		err.setDateTime(OffsetDateTime.now());
		err.setTitle(ex.getMessage());
		return handleExceptionInternal(ex,err, new HttpHeaders(), status, request);
	}
	
	

	@ExceptionHandler(BusinessExceptions.class)
	public ResponseEntity<Object> handlerBusiness(BusinessExceptions ex,  WebRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		Error err = new Error();
		err.setStatus(status.value());
		err.setDateTime(OffsetDateTime.now());
		err.setTitle(ex.getMessage());
		return handleExceptionInternal(ex,err, new HttpHeaders(), status, request);
	}
	
}
 