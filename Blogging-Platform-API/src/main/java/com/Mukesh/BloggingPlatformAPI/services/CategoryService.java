package com.Mukesh.BloggingPlatformAPI.services;

import com.Mukesh.BloggingPlatformAPI.models.Category;
import com.Mukesh.BloggingPlatformAPI.models.dto.CategoryDto;
import com.Mukesh.BloggingPlatformAPI.repositories.ICategoryRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    ICategoryRepo categoryRepo;


    // create
    public Category createCategory(Category category){
        Category savedCategory = categoryRepo.save(category);
        return savedCategory;
    }


    //update
    public String updateCategory(CategoryDto categoryDto, Integer id){
      Category existingCategory = categoryRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d not found", id)));
      existingCategory.setCategoryTitle(categoryDto.getCategoryTitle());
      existingCategory.setCategoryDescription(categoryDto.getCategoryDescription());

      categoryRepo.save(existingCategory);

      return "Category Information updated successfully!!";
    }


    // delete
    public String deleteCategory(Integer id){

        Category existingCat = categoryRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d not found", id)));
        categoryRepo.delete(existingCat);
        return "Category with id ::=> "+id+" is successfully deleted";

    }

    //get one
    public Optional<Category> getCategoryById(Integer id){
       return categoryRepo.findById(id);
    }



    // get all
    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }



}
