package com.Mukesh.BloggingPlatformAPI.services;

import com.Mukesh.BloggingPlatformAPI.models.Category;
import com.Mukesh.BloggingPlatformAPI.models.Post;
import com.Mukesh.BloggingPlatformAPI.models.User;
import com.Mukesh.BloggingPlatformAPI.models.dto.PostDto;
import com.Mukesh.BloggingPlatformAPI.models.dto.PostResponseDto;
import com.Mukesh.BloggingPlatformAPI.repositories.ICategoryRepo;
import com.Mukesh.BloggingPlatformAPI.repositories.IPostRepo;
import com.Mukesh.BloggingPlatformAPI.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class PostService {
    @Autowired
    IPostRepo postRepo;

    @Autowired
    ICategoryRepo categoryRepo;

    @Autowired
    IUserRepo userRepo;

    //Create post
    public Post createPost(Post post){
         Post savedPost =  postRepo.save(post);
         return savedPost;
    }

    // update post
    public String updatePost(PostDto postDto, Integer id){
        Post existingPost = postRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d not found", id)));
        existingPost.setPostTitle(postDto.getPostTitle());
        existingPost.setPostContent(postDto.getPostContent());

        return "Post with id ::=> "+id+" is successfully updated";
    }

    // delete post
    public String deletePost(Integer id){
        Post existingPost = postRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d not found", id)));
        postRepo.delete(existingPost);
        return "Post with id ::=> "+id+" is successfully Deleted!!!";
    }

    // get post by id
    public Optional<Post> getPostById(Integer id){
        return postRepo.findById(id);
    }
    // get All posts
    public List<Post> getAllPosts(){
        return postRepo.findAll();
    }

    // Doing pagination and sorting

    public PostResponseDto getPostsByPagination(Integer pageNumber, Integer pageSize, String sortBy, String sortDir){

        Sort sort =null;
        if(sortDir.equalsIgnoreCase("asc")){
            sort = Sort.by(sortBy).ascending();
        }else{
            sort = Sort.by(sortBy).descending();
        }

        Pageable p = PageRequest.of(pageNumber,pageSize, sort);
        Page<Post> postPage = postRepo.findAll(p);
        List<Post> allPosts = postPage.getContent();

        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setContent(allPosts);
        postResponseDto.setPageNumber(postPage.getNumber());
        postResponseDto.setPageSize(postPage.getSize());
        postResponseDto.setTotalElements(postPage.getTotalElements());
        postResponseDto.setTotalPages(postPage.getTotalPages());
        postResponseDto.setLastPage(postPage.isLast());
        return postResponseDto;
    }


    // get all posts by category
    public List<Post> getPostsByCategory(Integer categoryId){

        Category existingCategory = categoryRepo.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Category with id %d not found", categoryId)));
        List<Post> posts = postRepo.findByCategory(existingCategory);
        return posts;
    }

    // get all posts by user
    public List<Post> getPostsByUser(Integer userId){

        User existingUser = userRepo.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d not found", userId)));
        List<Post> posts = postRepo.findByUser(existingUser);
        return posts;
    }

    // search posts by keyword||Title
    public List<Post> searchPosts(String keyword){
       List<Post> posts = postRepo.findByPostTitleContaining(keyword);
       return posts;
    }



}
