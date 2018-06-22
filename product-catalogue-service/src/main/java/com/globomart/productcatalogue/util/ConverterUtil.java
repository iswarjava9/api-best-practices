/**
 * @author Iswar
 */

package com.globomart.productcatalogue.util;

import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.globomart.productcatalogue.dto.ProductCategoryDto;
import com.globomart.productcatalogue.dto.ProductCategoryResponse;
import com.globomart.productcatalogue.dto.ProductDto;
import com.globomart.productcatalogue.dto.ProductDtoV2;
import com.globomart.productcatalogue.model.Product;
import com.globomart.productcatalogue.model.ProductCategory;

@Service
public class ConverterUtil {

	@Resource
	public ModelMapper modelMapper;

	public ProductDto convertEntityToDto(Product product) {
		return modelMapper.map(product, ProductDto.class);
	}

	public Product convertDtoToEntity(ProductDto productDto) {
		Product p = modelMapper.map(productDto, Product.class);
		return p;
	}

	public List<ProductDto> convertToProductList(List<Product> products) {

		Type listType = new TypeToken<List<ProductDto>>(){}.getType();
		List<ProductDto> productDtoList = modelMapper.map(products, listType);
	
		return productDtoList;
	}
	
	public List<ProductDtoV2> convertToProductDtoV2List(List<Product> products) {

		Type listType = new TypeToken<List<ProductDtoV2>>(){}.getType();
		List<ProductDtoV2> productDtoList = modelMapper.map(products, listType);
	
		return productDtoList;
	}

	public ProductCategoryResponse convertToProductCategoryResponse(List<ProductCategory> productCategories) {
		/*
		 * for(ProductCategory pc : productCategories){
		 * 
		 * for(ProductSubCategory s : pc.getProductSubCategories()){
		 * System.out.println(s.getDisplayName()); for(Product pr :
		 * s.getProducts()){ Type listType = new TypeToken<List<ProductDto>>()
		 * {}.getType(); List<ProductCategoryDto> prodCatList =
		 * modelMapper.map(productCategories, listType); } } }
		 */

		Type listType = new TypeToken<List<ProductCategoryDto>>() {}.getType();
		List<ProductCategoryDto> prodCatList = modelMapper.map(productCategories, listType);
		ProductCategoryResponse productCategoryResponse = new ProductCategoryResponse(prodCatList);
		return productCategoryResponse;
	}
	

}
