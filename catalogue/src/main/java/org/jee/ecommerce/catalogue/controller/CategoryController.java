package org.jee.ecommerce.catalogue.controller;

import javax.websocket.server.PathParam;

import org.jee.ecommerce.catalogue.model.CategoryDto;
import org.jee.ecommerce.catalogue.service.CategoryService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private final CategoryService CategoryService;
	
	public CategoryController(CategoryService CategoryService) {
		super();
		this.CategoryService = CategoryService;
	}

	@PostMapping()
	public CategoryDto doCreateCategory(@RequestBody CategoryDto Category) throws Exception {
		return CategoryService.doCreateCategory(Category);
	}
	
	@PutMapping()
	public CategoryDto doUpdateCategory(@RequestBody CategoryDto Category) throws Exception {
		return CategoryService.doUpdateCategory(Category);
	}
	
	@DeleteMapping("/{id}")
	public void doDeleteCategory(@PathParam(value = "id") long  id) throws Exception {
		CategoryService.doDeleteCategory(id);
	}
	
}
