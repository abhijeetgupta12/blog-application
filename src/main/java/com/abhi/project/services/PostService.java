package com.abhi.project.services;

import java.util.List;

import com.abhi.project.payloads.PostDto;

public interface PostService {
	
	PostDto createPost(PostDto postDto, Integer uId, Integer cId);
	
	PostDto updatePost(PostDto postDto,Integer post_id);
	
	void deletePost(Integer post_id);
	
	List<PostDto> getAllPosts();
	
	PostDto getPostById(Integer post_id);
	
	List<PostDto> getPostByCategory(Integer category_id);
	
	List<PostDto> getPostByUser(Integer user_id);
	
	List<PostDto> searchPost(String keyword);

}
