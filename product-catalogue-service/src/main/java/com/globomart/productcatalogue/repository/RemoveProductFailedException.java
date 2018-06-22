/**
 * @author Iswar
 */

package com.globomart.productcatalogue.repository;

import com.globomart.productcatalogue.common.BaseException;
import com.globomart.productcatalogue.common.ErrorResponse;

public class RemoveProductFailedException extends BaseException {

private static final long serialVersionUID = 1L;
	
	public RemoveProductFailedException(Throwable e) {
		super(new ErrorResponse(1003), e);
	}
}
