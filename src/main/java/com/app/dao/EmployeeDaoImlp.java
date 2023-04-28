package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojo.Employee;

@Repository
public interface EmployeeDaoImlp extends JpaRepository<Employee, Integer> {
	
//	Employee findById(int id);
	Employee findByEmail(String email);
}
