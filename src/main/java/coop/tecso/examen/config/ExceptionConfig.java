package coop.tecso.examen.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import coop.tecso.examen.config.exceptions.BadRequestException;
import coop.tecso.examen.config.exceptions.NotFoundException;
import coop.tecso.examen.model.ApiError;

@ControllerAdvice
public class ExceptionConfig {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> NotFoundException(Exception e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(HttpStatus.NOT_FOUND.name(),e.getMessage(),e.toString()));
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> BadRequestException(Exception e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST.name(),e.getMessage(),e.toString()));
	}
	
	@ExceptionHandler({ TransactionSystemException.class })
	public ResponseEntity<ApiError> constraintViolationException(HttpServletRequest request, TransactionSystemException e) {
	    Throwable cause = ((TransactionSystemException) e).getRootCause();
	    final List<String> errors = new ArrayList<String>();
	    if (cause instanceof ConstraintViolationException) {
	       ConstraintViolationException consEx = (ConstraintViolationException) cause;
	       for(final ConstraintViolation<?> violation : consEx.getConstraintViolations()) {
	    	   errors.add(violation.getPropertyPath() + ":" + violation.getMessage());
	       }
	    }
	    ApiError errorInfo = new ApiError(HttpStatus.BAD_REQUEST.name(),e.getMessage(),e.toString());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler({ DataIntegrityViolationException.class })
	public ResponseEntity<ApiError> constraintViolationException(DataIntegrityViolationException e) {
	    ApiError errorInfo = new ApiError(HttpStatus.BAD_REQUEST.name(),"Ocurrió un error ingresando el registro en el sistema.",e.toString());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
	 
}
