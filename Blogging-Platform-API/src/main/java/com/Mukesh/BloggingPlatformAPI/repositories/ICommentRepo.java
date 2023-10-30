package com.Mukesh.BloggingPlatformAPI.repositories;

import com.Mukesh.BloggingPlatformAPI.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepo extends JpaRepository<Comment, Integer> {
}
