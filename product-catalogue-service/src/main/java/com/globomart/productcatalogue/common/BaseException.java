/**
 * @author Iswar
 */
package com.globomart.productcatalogue.common;

public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private ErrorResponse errorResponse;

	public BaseException(ErrorResponse errorResponse, Throwable e) {
		super(e);
		this.errorResponse = errorResponse;

	}

	public BaseException(ErrorResponse errorResponse) {

		this.errorResponse = errorResponse;

	}

	public BaseException(ErrorResponse errorResponse, String errorMessage) {
		super();
		this.errorResponse = errorResponse;

	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

}
