package com.turkcell.ecommerce.repository;

import com.turkcell.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsCategoriesByName(String name);
}
