/**
 * @author Iswar
 */

package com.globomart.productcatalogue.dto;

import java.util.List;

public class ProductListResponse {

	private List<ProductDto> productList;

	public ProductListResponse(List<ProductDto> productDtoList) {
		this.productList = productDtoList;
	}

	public List<ProductDto> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductDto> productList) {
		this.productList = productList;
	}
	
	
}
