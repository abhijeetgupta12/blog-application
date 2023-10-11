package com.abhi.project.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 4,message = "User Namme must be minimum of 4 characters")
	private String name;
	
	@Email(message = "Email Address not valid")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max = 10,message = "Pass should be between 3 t0 10 chars")
	private String password;
	
	@NotEmpty
	private String about;

}
