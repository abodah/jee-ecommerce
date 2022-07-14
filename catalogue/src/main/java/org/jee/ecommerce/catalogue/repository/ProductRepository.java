package org.jee.ecommerce.catalogue.repository;

import org.jee.ecommerce.catalogue.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
