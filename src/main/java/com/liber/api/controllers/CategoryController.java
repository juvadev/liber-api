package com.liber.api.controllers;

import com.liber.api.models.Category;
import com.liber.api.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ArrayList<Category> getCategories () {
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById (@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/save")
    public Category saveCategory (@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping("/update/{id}")
    public Category updateCategoryById (@PathVariable int id, @RequestBody Category category) {
        return categoryService.updateCategoryById(id, category);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteCategoryById (@PathVariable int id) {
        return categoryService.deleteCategoryById(id);
    }
}
