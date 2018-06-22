/**
 * @author Iswar
 */

package com.globomart.productcatalogue.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.globomart.productcatalogue.model.Product;
import com.globomart.productcatalogue.model.ProductCategory;

public interface ProductCatalogueService {
	public List<Product> findProductsByType(String type);
	public Product addProduct(Product product);
	public void removeProduct(Integer id);
	public Product findProductById(Integer id);
	public List<ProductCategory> findProductCategories();
	public List<Product> findAllProducts();
	public void updateProduct(Product product);
	public List<Product> findProductsPaginated(PageRequest pageRequest);
}
