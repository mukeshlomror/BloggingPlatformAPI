package com.Mukesh.BloggingPlatformAPI.repositories;

import com.Mukesh.BloggingPlatformAPI.models.Category;
import com.Mukesh.BloggingPlatformAPI.models.Post;
import com.Mukesh.BloggingPlatformAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    List<Post> findByPostTitleContaining(String postTitle);
}
