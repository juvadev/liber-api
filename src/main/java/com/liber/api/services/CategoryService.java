package com.liber.api.services;

import com.liber.api.models.Category;
import com.liber.api.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    public ArrayList<Category> getCategories () {
        return (ArrayList<Category>) categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById (int id) {
        return categoryRepository.findById(id);
    }

    public Category saveCategory (Category category) {
        return  categoryRepository.save(category);
    }

    public Category updateCategoryById (int id, Category request) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setName(request.getName());
            category.setDescription(request.getDescription());
            category.setState(request.getState());
            return categoryRepository.save(category);
        } else {
            throw new RuntimeException("Category not found with id " + id);
        }
    }

    public Boolean deleteCategoryById (int id) {
        try {
            categoryRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
