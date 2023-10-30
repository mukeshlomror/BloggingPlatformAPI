package com.Mukesh.BloggingPlatformAPI.services;

import com.Mukesh.BloggingPlatformAPI.models.Comment;
import com.Mukesh.BloggingPlatformAPI.models.Post;
import com.Mukesh.BloggingPlatformAPI.repositories.ICommentRepo;
import com.Mukesh.BloggingPlatformAPI.repositories.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CommentService {
    @Autowired
    ICommentRepo commentRepo;
    @Autowired
    IPostRepo postRepo;

    // Create Comment
    public Comment createComment(Comment comment, Integer postId){

        Post post = postRepo.findById(postId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Post with id %d not found", postId)));
        comment.setPost(post);
        Comment savedComment = commentRepo.save(comment);
        return savedComment;
    }

    // Delete Comment
    public String deleteComment(Integer id){
        Comment comment = commentRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Comment with id %d not found", id)));
        commentRepo.delete(comment);
        return "User with id ::=> "+id+" is successfully deleted!!!";
    }
}
