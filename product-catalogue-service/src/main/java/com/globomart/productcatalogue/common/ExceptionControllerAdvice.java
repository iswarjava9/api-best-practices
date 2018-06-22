/**
 * @author iswsahu
 */

package com.globomart.productcatalogue.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.globomart.productcatalogue.repository.AddProductFailedException;
import com.globomart.productcatalogue.repository.InvalidProducSubCategoryException;
import com.globomart.productcatalogue.repository.ProductNotFoundException;
import com.globomart.productcatalogue.repository.RemoveProductFailedException;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {
	@Autowired
	Environment env;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ex.printStackTrace();
		ErrorResponse errorResponse = new ErrorResponse(5000, env);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(ProductNotFoundException ex) {

		return new ResponseEntity<ErrorResponse>(ex.getErrorResponse(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AddProductFailedException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(AddProductFailedException ex) {

		return new ResponseEntity<ErrorResponse>(ex.getErrorResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RemoveProductFailedException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(RemoveProductFailedException ex) {
		ex.printStackTrace();
		return new ResponseEntity<ErrorResponse>(ex.getErrorResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidProducSubCategoryException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(InvalidProducSubCategoryException ex) {
		ex.printStackTrace();
		return new ResponseEntity<ErrorResponse>(ex.getErrorResponse(), HttpStatus.PRECONDITION_FAILED);
	}
	
	/**
	 * This method is used to customize field validation error
	 */

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status, WebRequest request) {
       
		ErrorResponse errorDetails = new ErrorResponse(4000, buildValidationErrorMessage(ex));
				// new ErrorResponse(4000,ex.getBindingResult().getFieldError().getField()+ " "+ex.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);

	}
	
	private String buildValidationErrorMessage(MethodArgumentNotValidException ex){
		
		List<String> errorList = new ArrayList<>();
		for(FieldError fe : ex.getBindingResult().getFieldErrors()){
			errorList.add(fe.getField() + " "+fe.getDefaultMessage());
			
		}		
		return String.join(" , " , errorList);
	}

}
