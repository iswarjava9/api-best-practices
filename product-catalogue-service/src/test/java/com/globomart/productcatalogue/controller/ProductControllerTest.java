package com.globomart.productcatalogue.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.globomart.productcatalogue.dto.ProductDto;
import com.globomart.productcatalogue.model.Product;
import com.globomart.productcatalogue.model.ProductSubCategory;
import com.globomart.productcatalogue.service.ProductCatalogueService;
import com.globomart.productcatalogue.util.ConverterUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ConverterUtil converterUtil;
	
	@MockBean
	private ProductCatalogueService prodCatService;
	
	@Test
	public void retrieveProductsTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/api/products/2").accept(MediaType.APPLICATION_JSON);
		//when(converterUtil.convertDtoToEntity(buildProductDto())).thenReturn(buildProductEntity());
		when(prodCatService.findProductById(1)).thenReturn(buildProductEntity());
		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
		
	
	}
	
	/*private ProductDto buildProductDto(){
		ProductDto dto = new ProductDto();
		dto.setDescription("prod desc");
		dto.setDisplayName("prod display");
		dto.setId(123);
		dto.setProductSubCatId(1);
		dto.setSku("sku1");
		return dto;
	}*/
	
	private Product buildProductEntity(){
		Product entity = new Product();
		entity.setDescription("prod desc");
		entity.setDisplayName("prod display");
		entity.setId(123);
		entity.setProductSubCat(new ProductSubCategory());
		entity.setSku("sku1");
		return entity;
	}

}
