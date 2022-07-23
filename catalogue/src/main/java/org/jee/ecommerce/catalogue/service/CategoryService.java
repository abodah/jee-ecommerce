package org.jee.ecommerce.catalogue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.jee.ecommerce.catalogue.entity.Category;
import org.jee.ecommerce.catalogue.entity.Product;
import org.jee.ecommerce.catalogue.model.CategoryDto;
import org.jee.ecommerce.catalogue.model.ProductDto;
import org.jee.ecommerce.catalogue.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CategoryService {

	 
	private CategoryRepository categoryRepository;
	private final ObjectMapper mapper = new ObjectMapper();

	public CategoryService(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	
	public List<CategoryDto> doListCategory() {
		List<Category> listCats = categoryRepository.findAll();
		
		return listCats.stream().map(category -> toCategoryDto(category)).collect(Collectors.toList());
	}

	public CategoryDto doCreateCategory(CategoryDto CategoryDto) throws Exception {
		// mapper
		Category category = mapper.readValue(mapper.writeValueAsString(CategoryDto), Category.class); // dto --> model
		category = categoryRepository.save(category);
		return mapper.readValue(mapper.writeValueAsString(category), CategoryDto.class); // model ---> dto
	}
	
	public CategoryDto doUpdateCategory(CategoryDto categoryDto) throws Exception {
		Category category = categoryRepository.findById(categoryDto.getId()).get();
		Category categoryToSave = mapper.readValue(mapper.writeValueAsString(categoryDto), Category.class);
		categoryToSave.setId(category.getId());
		category = categoryRepository.save(category);
		return mapper.readValue(mapper.writeValueAsString(category), CategoryDto.class); // model ---> dto
	}
	
	public void doDeleteCategory(long id) throws Exception {
		categoryRepository.deleteById(id);
	}
	
	
	public static CategoryDto toCategoryDto(Category category) {
		CategoryDto dto = new CategoryDto();
		dto.setId(category.getId());
		dto.setName(category.getName());
		dto.setDescription(category.getDescription());
		dto.setActive(category.isActive());
		return dto;
	}
	
}
