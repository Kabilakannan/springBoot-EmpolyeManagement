package com.example.Backend;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/empolyees")
public class EmpolyeeController {
	
  private EmpolyeeService empolyeeService;
  
  @PostMapping
  public ResponseEntity<EmpolyeeDto> createEmpolyee(@RequestBody EmpolyeeDto empolyeeDto){
	  EmpolyeeDto savedEmpolyee=empolyeeService.createEmpolyee(empolyeeDto);
	  return new ResponseEntity<>(savedEmpolyee,HttpStatus.CREATED);
  }
  
  @GetMapping("{id}")
  public ResponseEntity<EmpolyeeDto> getEmpolyeeByid(@PathVariable("id") Long EmpolyeeId){
	  EmpolyeeDto empolyeeDto=empolyeeService.getEmpolyeeById(EmpolyeeId);
	  return ResponseEntity.ok(empolyeeDto);
  }
  
  @GetMapping
  public ResponseEntity<List<EmpolyeeDto>> getAllEmpolyee(){
	  List<EmpolyeeDto> empolyeeDto=empolyeeService.getAllEmpolyee();
	  return ResponseEntity.ok(empolyeeDto);
  }
  
  @PutMapping("{id}")
  public ResponseEntity<EmpolyeeDto> updateEmpolyee(@PathVariable("id") Long empolyeeId,@RequestBody EmpolyeeDto updateEmpolyee){
	   EmpolyeeDto empolyeeDto=empolyeeService.updateEmpolyee(empolyeeId, updateEmpolyee);
	   return ResponseEntity.ok(empolyeeDto);
  }
  
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteEmpolyee(@PathVariable("id") Long empolyeeId){
	   empolyeeService.deleteEmpolyee(empolyeeId);
	   return ResponseEntity.ok("Empolyee Deleted");
  }
  
  
  
}
