package org.jee.ecommerce.catalogue.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.jee.ecommerce.catalogue.entity.Category;
import org.jee.ecommerce.catalogue.entity.Product;
import org.jee.ecommerce.catalogue.model.ProductDto;
import org.jee.ecommerce.catalogue.repository.CategoryRepository;
import org.jee.ecommerce.catalogue.repository.ProductRepository;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductService {

	 
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	private final ObjectMapper mapper = new ObjectMapper();

	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	public ProductDto doCreateProduct(ProductDto productDto) throws Exception {
		// mapper
		
		Product product = mapper.readValue(mapper.writeValueAsString(productDto), Product.class); // dto --> model
		Category category = categoryRepository.findById(productDto.getDefaultCategory().getId()).orElseThrow(() -> new Exception("Category not found"));
		product.setDefaultCategory(category);
		product = productRepository.save(product);
		//return mapper.readValue(mapper.writeValueAsString(product), ProductDto.class); // model ---> dto
		return toProductDto(product);
	}
	
	private ProductDto toProductDto(Product product) {
		ProductDto dto = new ProductDto();
		dto.setReference(product.getReference());
		dto.setName(product.getName());
		dto.setDescription(product.getDescription());
		dto.setActive(product.isActive());
		dto.setDefaultCategory(CategoryService.toCategoryDto(product.getDefaultCategory()));
		return dto;
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

	public List<ProductDto> doListProduct() {
		List<Product> listPdts = productRepository.findAll();
		
		return listPdts.stream().map(product -> toProductDto(product)).collect(Collectors.toList());
	}
	
	
}
