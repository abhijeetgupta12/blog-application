package com.abhi.project.services.implementaions;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.project.entities.Category;
import com.abhi.project.entities.Post;
import com.abhi.project.entities.User;
import com.abhi.project.exceptions.ResourceNotFound;
import com.abhi.project.payloads.PostDto;
import com.abhi.project.repositories.CategoryRepo;
import com.abhi.project.repositories.PostRepo;
import com.abhi.project.repositories.UserRepo;
import com.abhi.project.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private PostRepo postRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PostDto createPost(PostDto postDto, Integer uId, Integer cId) {
		// TODO Auto-generated method stub
		
		
		User user = this.userRepo.findById(uId).orElseThrow(()-> new ResourceNotFound("User", "User Id", uId));
		Category category = this.categoryRepo.findById(cId).orElseThrow(()-> new ResourceNotFound("Category", "Category Id", cId));
		
		System.out.println(user.getId()+" "+category.getCategoryId());
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setAddedDate(new Date());
		post.setImageName("default.png");
		post.setCategory(category);
		post.setUser(user);
		
		Post createdPost = this.postRepository.save(post);
		
		return this.modelMapper.map(createdPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer post_id) {

		Post post = this.postRepository.findById(post_id).orElseThrow(()-> new ResourceNotFound("Post", "Post Id", post_id));
		
		System.out.println(post.getUser().getId());
		
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		post.setAddedDate(new Date());
		
		Post updatedPost = this.postRepository.save(post);
		
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer post_id) {

		Post post = this.postRepository.findById(post_id).orElseThrow(()-> new ResourceNotFound("Post", "Post Id", post_id));
		this.postRepository.delete(post);
	}

	@Override
	public List<PostDto> getAllPosts() {

		List<Post> allData = this.postRepository.findAll();
		
		List<PostDto> foundData =  allData.stream().map(data -> this.modelMapper.map(data, PostDto.class)).toList();
		
		return foundData;
	}

	@Override
	public PostDto getPostById(Integer post_id) {
		
		Post post = this.postRepository.findById(post_id).orElseThrow(()-> new ResourceNotFound("Post", "Post Id", post_id));
		
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer category_id) {
		
		Category category = this.categoryRepo.findById(category_id).orElseThrow(()-> new ResourceNotFound("Category", "Category Id", category_id));
		
		List<Post> posts = this.postRepository.findPostByCategory(category);
		
		List<PostDto> postDtos = posts.stream().map(post -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer user_id) {
		
		User user = this.userRepo.findById(user_id).orElseThrow(()-> new ResourceNotFound("User", "User Id", user_id));
		
		List<Post> posts = this.postRepository.findPostByUser(user);
		
		List<PostDto> postDtos = posts.stream().map(post -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
