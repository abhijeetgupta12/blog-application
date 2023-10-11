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

import com.abhi.project.payloads.UserDto;
import com.abhi.project.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/add")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		
		UserDto savedUser = this.userService.createUser(userDto);
		
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer uid){
		
		UserDto updatedUser = this.userService.updateUser(userDto, uid);
		
		return ResponseEntity.ok(updatedUser);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer id){
		
		UserDto user = this.userService.getUserById(id);
		
		return ResponseEntity.ok(user);
		
	}
	
	@GetMapping("/find")
	public ResponseEntity<List<UserDto>> getAllUser(){
		
		List<UserDto> user = this.userService.getAllUsers();
		
		return ResponseEntity.ok(user);
		
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id){
		
		this.userService.deleteUser(id);
		
		return new ResponseEntity<>(Map.of("message","user deleted successfully"),HttpStatus.OK);
	}
	
	
	/*
	 * use ResponseEntitiy class if you want to send data with status
	 * If you are getting a JSON object from user retrieve it using @RequestBody as shown above
	 * If you are getting a value in API from user retrieve it using  @PathVariable  as shown above
	 * In the above 2 cases of path variable use first if you want to change the name else second
	 * 
	 * */

}
