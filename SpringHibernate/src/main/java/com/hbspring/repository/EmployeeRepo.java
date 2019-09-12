package com.hbspring.repository;



import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hbspring.model.Employee;




@Repository
public class EmployeeRepo {
	@Autowired
	SessionFactory sf;
	
	@Transactional
		public Employee saveEmployee(Employee emp) {
			
			Session ssn=sf.openSession();
			Transaction tx=ssn.beginTransaction();
			ssn.save(emp);
			return emp;
			
			
		
		}
	@Transactional
	public Employee getEmployee(int empId) {
		Session ssn=sf.openSession();
				return ssn.get(Employee.class,empId);
	}
	
	@Transactional
	public List<Employee> getAllEmployee(){
		Session ssn=sf.openSession();
		Criteria ctr=ssn.createCriteria(Employee.class);
		return(ctr.list());
	}
	
	@Transactional
	public boolean deleteEmoloyee(int empId) {
		Session ssn=sf.openSession();
		ssn.beginTransaction();
		Query q=ssn.createQuery("delete from Employee where empId=:empId");
		q.setParameter("empId", empId);
		q.executeUpdate();
		//ssn.delete(empId);
		return true;
	}
	
	@Transactional
	public Employee updateEmp(Employee emp,int empId,String empName,int age) {
		Session ssn=sf.openSession();
		ssn.beginTransaction();
		Query q=ssn.createQuery("update Employee set empNAME=:empName, age=:age where empId=:empId");
		q.setParameter("empId", empId);
		q.executeUpdate();
		return emp;
		 
}
}
