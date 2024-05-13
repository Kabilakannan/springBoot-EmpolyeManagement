package com.example.Backend;

import org.springframework.beans.factory.annotation.Autowired;

public class EmpolyeeMapper {

 public static EmpolyeeDto mapToEmpolyeeDto(@Autowired Empolyee empolyee) {	 
	 return new EmpolyeeDto(
			 empolyee.getId(),
			 empolyee.getFirstName(),
			 empolyee.getLastName(),
			 empolyee.getEmail()
			 );
 }
 
 public static Empolyee mapToEmpolyee(EmpolyeeDto empolyeeDto) {
	 return new Empolyee(empolyeeDto.getId(),
			 empolyeeDto.getFirstName(),
			 empolyeeDto.getLastName(),
			 empolyeeDto.getEmail());
 }
	
}
