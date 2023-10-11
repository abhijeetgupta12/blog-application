package com.abhi.project.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.abhi.project.payloads.PostDto;
import com.abhi.project.services.PostService;


@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private PostService postService;

	//Add Post
	@PostMapping("/uid/{uId}/cid/{cId}")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer uId, @PathVariable Integer cId) {
		
		PostDto createdPost = this.postService.createPost(postDto, uId, cId);
		
		return new ResponseEntity<PostDto>(createdPost,HttpStatus.CREATED);
				
	}
	
	//Update Post
	@PostMapping("/update/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){
		
		PostDto updatedPost = this.postService.updatePost(postDto, postId);
		
		return new ResponseEntity<PostDto>(updatedPost,HttpStatus.OK);
		
	}
	
	//Get Post by Id
	@GetMapping("/post/pId/{pId}")
	public ResponseEntity<PostDto> getDataById(@PathVariable Integer pId){
		
		PostDto data = this.postService.getPostById(pId);
		
		return new ResponseEntity<PostDto>(data,HttpStatus.FOUND);
		
	}
	
	//Get All Posts
	@GetMapping("/allPosts")
	public ResponseEntity<List<PostDto>> getAllData(){
		
		List<PostDto> allData = this.postService.getAllPosts();
		
		return new ResponseEntity<List<PostDto>>(allData,HttpStatus.FOUND);
		
	}
	
	
	//Get all Posts by Category
	@GetMapping("/category/{cId}")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer cId){
		
		List<PostDto> postDtos = this.postService.getPostByCategory(cId);
		
		return new ResponseEntity<>(postDtos,HttpStatus.OK);
		
	}
	
	//Get all Posts by User
	@GetMapping("/user/{uId}")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer uId){
		
		List<PostDto> postDtos = this.postService.getPostByUser(uId);
		
		return new ResponseEntity<>(postDtos,HttpStatus.OK);
		
	}
	
	//Delete Post by Id
	@DeleteMapping("/delete/pId/{pId}")
	public ResponseEntity<?> deletePost(@PathVariable Integer pId){
		
		this.postService.deletePost(pId);
		
		return new ResponseEntity<>(Map.of("message","user deleted successfully"),HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/hello/{uid}")
	public String hello(@PathVariable Integer uid) {
		System.out.println(uid);
		return "Hello";
	}
}
