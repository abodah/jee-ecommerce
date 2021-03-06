package org.jee.ecommerce.catalogue.service;

import org.jee.ecommerce.catalogue.entity.Product;
import org.jee.ecommerce.catalogue.model.ProductDto;
import org.jee.ecommerce.catalogue.repository.ProductRepository;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductService {

	 
	private ProductRepository productRepository;
	private final ObjectMapper mapper = new ObjectMapper();

	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	public ProductDto doCreateProduct(ProductDto productDto) throws Exception {
		// mapper
		Product product = mapper.readValue(mapper.writeValueAsString(productDto), Product.class); // dto -- model
		product = productRepository.save(product);
		return mapper.readValue(mapper.writeValueAsString(product), ProductDto.class); // model - dto
	}
	
	
	
}
