/**
 * @author Iswar
 */
package com.globomart.productcatalogue.dto;

import java.util.List;

public class ProductCategoryDto {
	private Integer id;
	private String displayName;
	private String description;
	private List<ProductSubCategoryDto> productSubCategories;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProductSubCategoryDto> getProductSubCategories() {
		return productSubCategories;
	}

	public void setProductSubCategories(List<ProductSubCategoryDto> productSubCategories) {
		this.productSubCategories = productSubCategories;
	}

}
