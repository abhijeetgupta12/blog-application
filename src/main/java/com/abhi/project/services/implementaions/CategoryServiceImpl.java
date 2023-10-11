package com.abhi.project.services.implementaions;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.project.entities.Category;
import com.abhi.project.exceptions.ResourceNotFound;
import com.abhi.project.payloads.CategoryDto;
import com.abhi.project.repositories.CategoryRepo;
import com.abhi.project.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		
		
		Category cat = this.modelMapper.map(categoryDto,Category.class);
		Category addedCategory = this.categoryRepository.save(cat);
		
		return this.modelMapper.map(addedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categorydto, Integer categoryId) {
		// TODO Auto-generated method stub
		
		Category cat = this.categoryRepository.findById(categoryId).
				orElseThrow(()-> new ResourceNotFound("Category","Id",categoryId));
		
		cat.setCategoryTitle(categorydto.getCategoryTitle());
		cat.setCategoryDesc(categorydto.getCategoryDesc());
		
		Category updatedCategory = this.categoryRepository.save(cat);
		
		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		
		Category cat = this.categoryRepository.findById(categoryId).
				orElseThrow(()-> new ResourceNotFound("Category","Id",categoryId));
		
		this.categoryRepository.delete(cat);
		
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		// TODO Auto-generated method stub
		
		Category cat = this.categoryRepository.findById(categoryId).
				orElseThrow(()-> new ResourceNotFound("Category","Id",categoryId));
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		
		List<Category> categories = this.categoryRepository.findAll();
		List<CategoryDto> categoryDto = categories.stream().map((cat)->
			this.modelMapper.map(cat, CategoryDto.class)
		).collect(Collectors.toList());
		
		return categoryDto;
	}

}
