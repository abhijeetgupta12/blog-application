package com.abhi.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.project.entities.Category;
import com.abhi.project.entities.Post;
import com.abhi.project.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findPostByCategory(Category category);
	
	List<Post> findPostByUser(User user);

}
