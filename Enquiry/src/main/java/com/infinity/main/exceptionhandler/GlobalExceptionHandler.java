package com.infinity.main.exceptionhandler;




import java.util.HashMap;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler
{
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> ExcHandlerMethod(MethodArgumentNotValidException ts)
	{
		Map<String, String>errors=new HashMap<String,String>();
		ts.getBindingResult().getFieldErrors().forEach(error->{
			String property=error.getField();
			String messege=error.getDefaultMessage();
			errors.put(property, messege);
			
			
			
			
		});
		
		
		return new ResponseEntity<Map<String,String>>(errors,HttpStatus.NOT_FOUND);
	}
		
	}
	
	