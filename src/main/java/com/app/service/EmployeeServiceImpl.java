package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDaoImlp;
import com.app.pojo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDaoImlp empDao;
	
	@Override
	public String addEmp(Employee emp) {
		// TODO Auto-generated method stub
		empDao.save(emp);
		return "Employee Addedd";
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Employee emp=empDao.findById(id).get();
		return emp;
	}

	@Override
	public Employee deleteById(int id) {
		// TODO Auto-generated method stub
		Employee emp =empDao.findById(id).get();
		empDao.delete(emp);
		return emp;
	}

	@Override
	public List<Employee> fetchAllEmp() {
		// TODO Auto-generated method stub
		return empDao.findAll();
	}

	@Override
	public Employee updateEmp(Employee emp1) {
		// TODO Auto-generated method stub
		
		return empDao.save(emp1);
	}

	@Override
	public Employee findByEmail(String email) {
		// TODO Auto-generated method stub
		return empDao.findByEmail(email);
	}
	
	
	
	

}
