package com.abhi.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.project.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
