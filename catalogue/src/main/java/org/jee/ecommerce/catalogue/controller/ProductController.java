package org.jee.ecommerce.catalogue.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.jee.ecommerce.catalogue.model.ProductDto;
import org.jee.ecommerce.catalogue.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@PostMapping()
	public ResponseEntity<?> doCreateProduct(@RequestBody ProductDto product)  {
		try {
			ProductDto productDto =  productService.doCreateProduct(product);
			return ResponseEntity.ok(product);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			return ResponseEntity.ok(ex.getMessage());
		}
	}
	
	@GetMapping()
	public List<ProductDto> doListProduct() throws Exception {
		return productService.doListProduct();
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
