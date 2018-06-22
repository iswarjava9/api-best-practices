package com.globomart.productcatalogue.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.globomart.productcatalogue.dto.ProductDtoV2;
import com.globomart.productcatalogue.service.ProductCatalogueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "products" , description="products api v2")
@RestController
@RequestMapping("v2/api/products")
@EnableWebMvc
public class ProducControllerV2 extends BaseController {
	
	@Autowired
	ProductCatalogueService productCatalogueService;
	
	@ApiOperation(value = "retrieve All Products")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "User's name", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "size", value = "User's email", required = false, dataType = "int", paramType = "query"),

	})
	
	@GetMapping
	public List<ProductDtoV2> retrieveAllProducts(@RequestParam(value = "page") Optional<Integer> page,
			@RequestParam(value = "size") Optional<Integer> size) {

		if (page.isPresent() && size.isPresent()) {
			return converterUtil.convertToProductDtoV2List(productCatalogueService
					.findProductsPaginated(new PageRequest(page.get(), size.get(), Direction.ASC, "id")));
		}
		return converterUtil.convertToProductDtoV2List(productCatalogueService.findAllProducts());

	}

}
