package org.jee.ecommerce.catalogue.repository;

import org.jee.ecommerce.catalogue.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findById(long id);
	
	void deleteById(long id);
} 
