/**
 * @author Iswar
 */

package com.globomart.productcatalogue.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product_subcategory")
public class ProductSubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String description;
	@Column(name="display_name")
	private String displayName;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy="productSubCat")	
	private List<Product> products;
	

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
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "ProductSubCategory [id=" + id + ", description=" + description + ", displayName=" + displayName
				+ ", products=" + products + "]";
	}
	
	
	
	
}
