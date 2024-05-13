package com.example.Backend;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmpolyeeServiceImplementation implements EmpolyeeService{

	private EmpolyeeRepo empolyeeRepo;
	@Override
	public EmpolyeeDto createEmpolyee(EmpolyeeDto empolyeeDto) {
		// TODO Auto-generated method stub
		Empolyee empolyee=EmpolyeeMapper.mapToEmpolyee(empolyeeDto);
		
		Empolyee savedEmpolyee=empolyeeRepo.save(empolyee);
		
		return EmpolyeeMapper.mapToEmpolyeeDto(savedEmpolyee);
	}
	
	@Override
	public EmpolyeeDto getEmpolyeeById(Long empolyeeId) {
	    Empolyee empolyee=empolyeeRepo.findById(empolyeeId).
	    		orElseThrow(()->new ResourceNotFoundException("Empolyee is not Exists"+empolyeeId));
		return EmpolyeeMapper.mapToEmpolyeeDto(empolyee);
	}

	@Override
	public List<EmpolyeeDto> getAllEmpolyee() {
		List<Empolyee> empolyees=empolyeeRepo.findAll();
		return empolyees.stream().map((empolyee)->EmpolyeeMapper.mapToEmpolyeeDto(empolyee)).collect(Collectors.toList());
	}

	@Override
	public EmpolyeeDto updateEmpolyee(Long empolyeeID, EmpolyeeDto updateEmpolyee) {
		Empolyee empolyee=empolyeeRepo.findById(empolyeeID).orElseThrow(()->new ResourceNotFoundException(" "));
		
		empolyee.setFirstName(updateEmpolyee.getFirstName());
		empolyee.setLastName(updateEmpolyee.getLastName());
		empolyee.setEmail(updateEmpolyee.getEmail());
		
		Empolyee updateEmpolyeeObj=empolyeeRepo.save(empolyee);
		return EmpolyeeMapper.mapToEmpolyeeDto(updateEmpolyeeObj);
	}

	@Override
	public void deleteEmpolyee(Long empolyeeId) {
		// TODO Auto-generated method stub
		Empolyee empolyee=empolyeeRepo.findById(empolyeeId).orElseThrow(()->new ResourceNotFoundException(" "));
		
		empolyeeRepo.deleteById(empolyeeId);
		
	}

}
