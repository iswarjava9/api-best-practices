/**
 * @author Iswar
 */

package com.globomart.productcatalogue.repository;

import com.globomart.productcatalogue.common.BaseException;
import com.globomart.productcatalogue.common.ErrorResponse;

public class AddProductFailedException extends BaseException{

	private static final long serialVersionUID = 1L;
	
	public AddProductFailedException(Throwable e) {
		super(new ErrorResponse(1000), e);
	}
}
