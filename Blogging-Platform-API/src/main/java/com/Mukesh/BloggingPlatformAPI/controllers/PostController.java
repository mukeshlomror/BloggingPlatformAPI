package com.Mukesh.BloggingPlatformAPI.controllers;

import com.Mukesh.BloggingPlatformAPI.models.Post;
import com.Mukesh.BloggingPlatformAPI.models.dto.PostDto;
import com.Mukesh.BloggingPlatformAPI.models.dto.PostResponseDto;
import com.Mukesh.BloggingPlatformAPI.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/posts")
public class PostController {
    @Autowired
    PostService postService;

    //POST --> create post
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Post createPost(@Valid @RequestBody Post post){
       return postService.createPost(post);
    }

    // GET --> get post by ID
    @GetMapping("/getOne/{id}")
    public Optional<Post> getPostById(@PathVariable Integer id){
        return postService.getPostById(id);
    }

    //GET --> get all post
    @GetMapping("/getAll")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    //DELETE --> delete post by id
    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable Integer id ){
        return postService.deletePost(id);
    }

    //PUT --> update post by id
    @PutMapping("/update/{id}")
    public String updatePost(@Valid @RequestBody PostDto postDto, @PathVariable Integer id){
        return postService.updatePost(postDto, id);
    }

    //GET --> get all posts by user
    @GetMapping("/getByUser/{id}")
    public List<Post> getPostsByUser(@Valid @PathVariable Integer id){
        List<Post> posts = postService.getPostsByUser(id);
        return posts;
    }

    //GET --> get all posts by category
    @GetMapping("/getByCategory/{id}")
    public List<Post> getPostsByCategory(@Valid @PathVariable Integer id){
        List<Post> posts = postService.getPostsByCategory(id);
        return posts;
    }

    // get post by pagination
    @GetMapping("/pagination")
    public PostResponseDto getPostsByPagination(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber, @RequestParam(value = "pageSize", defaultValue = "2", required = false) Integer pageSize, @RequestParam(value = "sortBy", defaultValue = "postId",required = false) String sortBy, @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir){
        return postService.getPostsByPagination(pageNumber, pageSize,sortBy, sortDir);
    }

    //Search posts by title
    @GetMapping("/search/{keyword}")
    public List<Post> searchPosts(@PathVariable String keyword){
        return postService.searchPosts(keyword);
    }


}
