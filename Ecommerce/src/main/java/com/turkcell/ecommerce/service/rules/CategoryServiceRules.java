package com.turkcell.ecommerce.service.rules;

import com.turkcell.ecommerce.constant.ExceptionConstant;
import com.turkcell.ecommerce.exception.BusinessException;
import com.turkcell.ecommerce.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceRules {
    private final CategoryRepository repository;

    public void checkIfCategoryExistsById(int id){
        if(!repository.existsById(id)){
            throw new BusinessException(ExceptionConstant.CATEGORY_NOT_FOUND);
        }
    }

    public void checkIfCategoryExistsByName(String name){
        if(repository.existsCategoriesByName(name)){
            throw new BusinessException(ExceptionConstant.CATEGORY_ALREADY_EXISTS);
        }
    }
}
