package com.hbspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbspring.model.Employee;
import com.hbspring.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo repo;
	
	public Employee saveEmployee(Employee emp) {
		return repo.saveEmployee(emp); 
	}

	
		public Employee getEmployee(int empId) {
			return repo.getEmployee(empId);
		}
		
		public boolean deleteEmployee(int empId) {
			return repo.deleteEmoloyee(empId);
			
		}
		
		public List<Employee> getAllEmployee(){
			return repo.getAllEmployee();
		}
		
		public Employee updEployee(Employee emp) {
			Employee myemp =repo.getEmployee(emp.getEmpId());
			myemp.setAge(emp.getAge());
			
			myemp.setEmpName(emp.getEmpName());
			return repo.saveEmployee(myemp);		
			}
}
