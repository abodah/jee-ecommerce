package org.jee.ecommerce.catalogue.controller;

import javax.websocket.server.PathParam;

import org.jee.ecommerce.catalogue.model.ProductDto;
import org.jee.ecommerce.catalogue.service.ProductService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@PostMapping()
	public ProductDto doCreateProduct(@RequestBody ProductDto product) throws Exception {
		return productService.doCreateProduct(product);
	}
	
	@PutMapping()
	public ProductDto doUpdateProduct(@RequestBody ProductDto product) throws Exception {
		return productService.doUpdateProduct(product);
	}
	
	@DeleteMapping("/{reference}")
	public void doDeleteProduct(@PathParam(value = "reference") String  reference) throws Exception {
		productService.doDeleteProduct(reference);
	}
	
}
