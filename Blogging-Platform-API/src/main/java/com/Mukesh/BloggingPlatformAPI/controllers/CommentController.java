package com.Mukesh.BloggingPlatformAPI.controllers;

import com.Mukesh.BloggingPlatformAPI.models.Comment;
import com.Mukesh.BloggingPlatformAPI.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    //POST --> create comment
    @PostMapping("create/post/{postId}")
    public Comment createComment(@RequestBody Comment comment, @PathVariable Integer postId){
        return commentService.createComment(comment,postId);
    }

    //DELETE --> delete comment by Id
    @DeleteMapping("/delete/{commentId}")
    public String deleteComment(@PathVariable Integer commentId){
        return commentService.deleteComment(commentId);
    }

}
