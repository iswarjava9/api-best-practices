/**
 * @author Iswar
 */

package com.globomart.productcatalogue.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product_category")
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String description;
	
	@Column(name="display_name")	
	private String displayName;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
	@JoinColumn(name = "product_cat_id")
	private List<ProductSubCategory> productSubCategories;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public List<ProductSubCategory> getProductSubCategories() {
		return productSubCategories;
	}
	public void setProductSubCategories(List<ProductSubCategory> productSubCategories) {
		this.productSubCategories = productSubCategories;
	}
	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", description=" + description + ", displayName=" + displayName
				+ ", productSubCategories=" + productSubCategories + "]";
	}
	
	
}
