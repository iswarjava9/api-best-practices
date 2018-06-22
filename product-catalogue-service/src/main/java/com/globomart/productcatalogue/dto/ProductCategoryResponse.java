/**
 * @author Iswar
 */

package com.globomart.productcatalogue.dto;

import java.util.List;

public class ProductCategoryResponse {
List<ProductCategoryDto> productCategories;

public ProductCategoryResponse(List<ProductCategoryDto> productCategoryList) {
	this.productCategories = productCategoryList;
}

public List<ProductCategoryDto> getProductCategories() {
	return productCategories;
}

public void setProductCategories(List<ProductCategoryDto> productCategories) {
	this.productCategories = productCategories;
}


}
