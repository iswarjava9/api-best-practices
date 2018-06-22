/**
 * @author Iswar
 */

package com.globomart.productcatalogue.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.globomart.productcatalogue.dto.ProductDto;
import com.globomart.productcatalogue.service.ProductCatalogueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "products", description = "products api v1")
@RestController
@RequestMapping("/api/products")
@EnableWebMvc
public class ProductController extends BaseController {
	@Autowired
	ProductCatalogueService productCatalogueService;

	
	@GetMapping("/{id}")
	public ProductDto retrieveProducts(@PathVariable("id") Integer id) {

		return converterUtil.convertEntityToDto(productCatalogueService.findProductById(id));

	}

	@ApiOperation(value = "retrieve All Products")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "User's name", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "size", value = "User's email", required = false, dataType = "int", paramType = "query"),

	})
	
	@GetMapping
	public List<ProductDto> retrieveAllProducts(@RequestParam(value = "page") Optional<Integer> page,
			@RequestParam(value = "size") Optional<Integer> size) {

		if (page.isPresent() && size.isPresent()) {
			return converterUtil.convertToProductList(productCatalogueService
					.findProductsPaginated(new PageRequest(page.get(), size.get(), Direction.ASC, "id")));
		}
		return converterUtil.convertToProductList(productCatalogueService.findAllProducts());

	}

	
	@PostMapping
	public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDto productDto) {
		return new ResponseEntity<>(
				converterUtil.convertEntityToDto(
						productCatalogueService.addProduct(converterUtil.convertDtoToEntity(productDto))),
				HttpStatus.CREATED);

	}

	@PutMapping("/{id}")
	public void updateProduct(@RequestBody ProductDto productDto, @PathVariable("id") Integer id) {
		productDto.setId(id);
		productCatalogueService.updateProduct(converterUtil.convertDtoToEntity(productDto));

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeProduct(@PathVariable("id") Integer id) {
		productCatalogueService.removeProduct(id);

	}

}
