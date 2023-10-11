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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.project.payloads.CategoryDto;
import com.abhi.project.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/add")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		
		CategoryDto addedCategoryDto = this.categoryService.createCategory(categoryDto);
		
		return new ResponseEntity<>(addedCategoryDto,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer id ){
		
		CategoryDto updateCategoryDto = this.categoryService.updateCategory(categoryDto, id);
		
		return new ResponseEntity<>(updateCategoryDto,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer id){
		
		this.categoryService.deleteCategory(id);
		
		return new ResponseEntity<>(Map.of("message","user deleted successfully"),HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer id){
		
		CategoryDto retreivedCategory = this.categoryService.getCategoryById(id);
		
		return new ResponseEntity<>(retreivedCategory,HttpStatus.FOUND);
	}
	
	@GetMapping("/find")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		
		List<CategoryDto> list = this.categoryService.getAllCategory();
		
		return new ResponseEntity<>(list,HttpStatus.FOUND);
	}
	
	
	
	
	
	
}
