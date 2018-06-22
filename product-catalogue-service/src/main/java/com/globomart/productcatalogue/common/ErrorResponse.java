/**
 * @author Iswar
 */

package com.globomart.productcatalogue.common;

import org.springframework.core.env.Environment;

public class ErrorResponse{

	private Integer	errorCode;
	private String	errorMessage;

	private Environment envn = ApplicationContextProvider.getBean(Environment.class);


	public ErrorResponse() {

	}

	public ErrorResponse(Integer errorCode, Environment env) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = env.getProperty(String.valueOf(errorCode));
	}
	
	public ErrorResponse(Integer errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = message;
	}

	public ErrorResponse(Integer errorCode) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = envn.getProperty(String.valueOf(errorCode));
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {

		return errorMessage;
	}


}
