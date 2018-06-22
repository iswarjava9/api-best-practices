/**
 * @author Iswar
 */

package com.globomart.productcatalogue.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String sku;
	private String description;
	@Column(name="display_name")
	private String displayName;
	@ManyToOne
	@JoinColumn(name = "product_subcat_id")
	private ProductSubCategory productSubCat;
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
	public ProductSubCategory getProductSubCat() {
		return productSubCat;
	}
	public void setProductSubCat(ProductSubCategory productSubCat) {
		this.productSubCat = productSubCat;
	}
	
	
}
