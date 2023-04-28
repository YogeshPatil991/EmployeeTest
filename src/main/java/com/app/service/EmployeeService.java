package com.app.service;

import java.util.List;

import com.app.pojo.Employee;

public interface EmployeeService {
		
//	public String addEmp(Employee emp);
	public Employee findById(int id);
	public Employee deleteById(int id);
	public List<Employee> fetchAllEmp();
	public Employee updateEmp(Employee emp1);
	public Employee findByEmail(String email);
	public String addEmp(Employee emp);
}
