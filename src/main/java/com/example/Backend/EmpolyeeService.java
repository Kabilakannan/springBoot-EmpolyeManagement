package com.example.Backend;

import java.util.List;

public interface EmpolyeeService {

	 EmpolyeeDto createEmpolyee(EmpolyeeDto empolyeeDto);
	 EmpolyeeDto getEmpolyeeById(Long id);
	 List<EmpolyeeDto> getAllEmpolyee();
	 
	 EmpolyeeDto updateEmpolyee(Long empolyeeID,EmpolyeeDto empolyeeDto);
	 
	 void deleteEmpolyee(Long empolyeeId);
}

