package com.abhi.project.services;

import java.util.List;

import com.abhi.project.payloads.CategoryDto;


public interface CategoryService {
	
	//create
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	public CategoryDto updateCategory(CategoryDto categorydto,Integer categoryId);
	
	//delete
	public void deleteCategory(Integer categoryId);
	
	//get
	public CategoryDto getCategoryById(Integer categoryId);
	
	//getAll
	public List<CategoryDto> getAllCategory();

}
