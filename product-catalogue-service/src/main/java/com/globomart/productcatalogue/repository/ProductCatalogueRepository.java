/**
 * @author Iswar
 */

package com.globomart.productcatalogue.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.globomart.productcatalogue.model.Product;

@Repository
@Transactional
public interface ProductCatalogueRepository extends JpaRepository<Product, Integer>{
	
	List<Product> findByProductSubCatDisplayName(String displayName);
	
	

}
