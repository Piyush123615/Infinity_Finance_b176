package com.infinity.main.exceptionhandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;
@RestControllerAdvice
public class GlobalExceptionHandler
{
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, String>> ExcHandlerMethod(ConstraintViolationException ts)
	{
		Map<String, String>errors=new HashMap<String,String>();
		System.out.println("-----------------------------------------------------");
	     ts.getConstraintViolations().forEach(e->{
	    	 errors.put(e.getPropertyPath().toString(), e.getMessageTemplate());
	     }
	    );
		
		return new ResponseEntity(errors,HttpStatus.NOT_FOUND);
	}
		
}
