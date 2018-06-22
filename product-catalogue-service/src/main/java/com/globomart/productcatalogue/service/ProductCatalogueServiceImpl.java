/**
 * @author Iswar
 */

package com.globomart.productcatalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globomart.productcatalogue.model.Product;
import com.globomart.productcatalogue.model.ProductCategory;
import com.globomart.productcatalogue.repository.AddProductFailedException;
import com.globomart.productcatalogue.repository.InvalidProducSubCategoryException;
import com.globomart.productcatalogue.repository.ProductCatalogueRepository;
import com.globomart.productcatalogue.repository.ProductCategoryRepository;
import com.globomart.productcatalogue.repository.ProductNotFoundException;
import com.globomart.productcatalogue.repository.ProductSubCategoryRepository;
import com.globomart.productcatalogue.repository.RemoveProductFailedException;

@Service
public class ProductCatalogueServiceImpl implements ProductCatalogueService {

	@Autowired
	ProductCatalogueRepository productCatalogueRepository;

	@Autowired
	ProductCategoryRepository productCategoryRepository;

	@Autowired
	ProductSubCategoryRepository productSubCategoryRepository;

	@Override
	public List<Product> findProductsByType(String type) {
		List<Product> products = null;
		try {
			products = productCatalogueRepository.findByProductSubCatDisplayName(type);
		} catch (Exception e) {
			throw new ProductNotFoundException(e);
		}
		return products;
	}

	@Transactional
	@Override
	public Product addProduct(Product product) {
		if (!productSubCategoryRepository.exists((product.getProductSubCat().getId()))) {
			throw new InvalidProducSubCategoryException();
		}
		try{
		return productCatalogueRepository.save(product);
		}catch(Exception e){
			throw new AddProductFailedException(e);
		}

	}

	@Override
	public void removeProduct(Integer id) {
		try {
			productCatalogueRepository.delete(id);;
		} catch (Exception e) {
			throw new RemoveProductFailedException(e);
		}

	}

	@Override
	public Product findProductById(Integer id) {
		try{
		return productCatalogueRepository.findOne((id));
		}catch(Exception e){
			throw new ProductNotFoundException(e);
		}
	}

	@Override
	@Transactional
	public List<ProductCategory> findProductCategories() {
		return productCategoryRepository.findAll();

	}

	@Override
	public List<Product> findAllProducts() {
		return productCatalogueRepository.findAll();
		
	}

	@Override
	public void updateProduct(Product product) {
		productCatalogueRepository.save(product);
	}

	@Override
	public List<Product> findProductsPaginated(PageRequest pageRequest) {
		return productCatalogueRepository.findAll(pageRequest).getContent();
	}

}
