package com.Mukesh.BloggingPlatformAPI.controllers;

import com.Mukesh.BloggingPlatformAPI.models.Category;
import com.Mukesh.BloggingPlatformAPI.models.dto.CategoryDto;
import com.Mukesh.BloggingPlatformAPI.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //POST --> Create Category
    @PostMapping("/create")
    public Category createCategory(@Valid @RequestBody Category category){
        return categoryService.createCategory(category);
    }

    //GET --> get all categories
    @GetMapping("/getAll")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    //GET --> get category by ID
    @GetMapping("/getOne/{id}")
    public Optional<Category> getCategoryById(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }

    //PUT --> update category information
    @PutMapping("/update/{id}")
    public String updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer id){
        return categoryService.updateCategory(categoryDto, id);
    }

    //Delete --> delete category
    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@Valid @PathVariable Integer id){
        return categoryService.deleteCategory(id);
    }

}
