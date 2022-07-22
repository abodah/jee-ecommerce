package org.jee.ecommerce.catalogue.service;

import org.jee.ecommerce.catalogue.entity.Category;
import org.jee.ecommerce.catalogue.model.CategoryDto;
import org.jee.ecommerce.catalogue.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CategoryService {

	 
	private CategoryRepository CategoryRepository;
	private final ObjectMapper mapper = new ObjectMapper();

	public CategoryService(CategoryRepository CategoryRepository) {
		super();
		this.CategoryRepository = CategoryRepository;
	}

	public CategoryDto doCreateCategory(CategoryDto CategoryDto) throws Exception {
		// mapper
		Category Category = mapper.readValue(mapper.writeValueAsString(CategoryDto), Category.class); // dto --> model
		Category = CategoryRepository.save(Category);
		return mapper.readValue(mapper.writeValueAsString(Category), CategoryDto.class); // model ---> dto
	}
	
	public CategoryDto doUpdateCategory(CategoryDto CategoryDto) throws Exception {
		Category Category = CategoryRepository.findById(CategoryDto.getId());
		Category CategoryToSave = mapper.readValue(mapper.writeValueAsString(CategoryDto), Category.class);
		CategoryToSave.setId(Category.getId());
		Category = CategoryRepository.save(Category);
		return mapper.readValue(mapper.writeValueAsString(Category), CategoryDto.class); // model ---> dto
	}
	
	public void doDeleteCategory(long id) throws Exception {
		CategoryRepository.deleteById(id);
	}
	
	
}
