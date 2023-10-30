package com.Mukesh.BloggingPlatformAPI.repositories;

import com.Mukesh.BloggingPlatformAPI.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category, Integer> {
}
