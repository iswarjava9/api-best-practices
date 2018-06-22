/**
 * @author Iswar
 */

package com.globomart.productcatalogue.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProductDto {
	private Integer id;
	@NotNull
	private String sku;
	private String description;
	private String displayName;
	@Min(value=1)
	private Integer productSubCatId;	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getProductSubCatId() {
		return productSubCatId;
	}

	public void setProductSubCatId(Integer productSubCatId) {
		this.productSubCatId = productSubCatId;
	}
	
	

}
