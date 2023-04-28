package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/Employee/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addEmp(@RequestBody Employee emp) {
		String res=empService.addEmp(emp);
		
			
		return new ResponseEntity(res, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findEmpById(@PathVariable int id){
		Employee emp=empService.findById(id);
		return new ResponseEntity(emp,HttpStatus.OK);
	}
	
	@GetMapping("delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id){
		Employee emp=empService.deleteById(id);
		return new ResponseEntity(emp,HttpStatus.OK);
		
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<?> fetchAllEmp(){
		List<Employee> empList=new ArrayList<Employee>();
		empList=empService.fetchAllEmp();
		return new ResponseEntity(empList, HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateEmp(@RequestBody Employee emp){
		
		Employee emp1=empService.findById(emp.getId());
		emp1.setFirstName(emp.getFirstName());
		emp1.setLastName(emp.getLastName());
		emp1.setEmail(emp.getEmail());
		emp1.setPassword(emp.getPassword());
		
		Employee updatedemp=empService.updateEmp(emp1);
		return new ResponseEntity(emp1,HttpStatus.OK);
		
	}
	
	@GetMapping("/email")
	public ResponseEntity<?> findByEmail(@RequestParam(value ="email")String email){
		Employee emp=empService.findByEmail(email);
		if(emp==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
}
