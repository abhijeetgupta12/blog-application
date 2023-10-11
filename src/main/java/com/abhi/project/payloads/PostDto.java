package com.abhi.project.payloads;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date date;
	
	private UserDto user; //Instead of User we are taking UserDto, as User again has Post which again
						  //will have User so it will create an InfiniteException
						  //This can be understood as one of the benefits of Dto	
	
	private CategoryDto category;//Same as above
}
