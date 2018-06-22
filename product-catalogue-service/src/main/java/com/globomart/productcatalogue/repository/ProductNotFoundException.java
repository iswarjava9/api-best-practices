/**
 * @author Iswar
 */

package com.globomart.productcatalogue.repository;

import com.globomart.productcatalogue.common.BaseException;
import com.globomart.productcatalogue.common.ErrorResponse;

public class ProductNotFoundException extends BaseException{

	
	
	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException(Throwable e) {
		super(new ErrorResponse(1002), e);
	}


	
}
