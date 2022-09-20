package com.admins.SpringBootCrud.Exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourseNotFoundException extends RuntimeException{
	
	String resourceName;
	String fieldName;
	long fieldValue;
	public ResourseNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("% Not found  with %s :% l", resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	

}
