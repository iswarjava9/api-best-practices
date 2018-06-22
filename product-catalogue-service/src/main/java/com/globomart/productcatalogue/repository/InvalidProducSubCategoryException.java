/**
 * @author Iswar
 */

package com.globomart.productcatalogue.repository;

import com.globomart.productcatalogue.common.BaseException;
import com.globomart.productcatalogue.common.ErrorResponse;

public class InvalidProducSubCategoryException extends BaseException{

	
	private static final long serialVersionUID = 1L;
	public InvalidProducSubCategoryException(Throwable e) {
		super(new ErrorResponse(1004), e);
	}
	
	public InvalidProducSubCategoryException() {
		super(new ErrorResponse(1004));
	}

	
}
