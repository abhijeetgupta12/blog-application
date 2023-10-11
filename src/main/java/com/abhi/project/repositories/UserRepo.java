package com.abhi.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.project.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	/* The methods under UserServiceImplementaion.java could have been directly written here
	without the use of UserDto.java but to avoid our entity getting directly exposed to services 
	we are using UserDto(used for transferring data to services) */ 

}
