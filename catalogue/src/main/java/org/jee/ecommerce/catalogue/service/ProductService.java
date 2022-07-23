package org.jee.ecommerce.catalogue.service;

import java.util.ArrayList;
import java.util.Arrays;

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
		Product product = mapper.readValue(mapper.writeValueAsString(productDto), Product.class); // dto --> model
		product = productRepository.save(product);
		return mapper.readValue(mapper.writeValueAsString(product), ProductDto.class); // model ---> dto
	}
	
	public ProductDto doUpdateProduct(ProductDto productDto) throws Exception {
		Product product = productRepository.findByReference(productDto.getReference());
		// On créé un nouvel objet pour remapper, a priori on peut écrire directement une requête SQL de MAJ dans le repository et passer le DTO
		Product productToSave = mapper.readValue(mapper.writeValueAsString(productDto), Product.class);
		productToSave.setId(product.getId());
		product = productRepository.save(product);
		return mapper.readValue(mapper.writeValueAsString(product), ProductDto.class); // model ---> dto
	}
	
	public void doDeleteProduct(String reference) throws Exception {
		productRepository.deleteByReference(reference);
	}

	public ArrayList<ProductDto> doListProduct() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}
	
	
}
