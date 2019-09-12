package com.hbspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hbspring.model.Employee;
import com.hbspring.service.EmployeeService;

@Controller
public class EmployeeController {
	 	@Autowired
		EmployeeService service;
	 	
	 	@PostMapping("/add")
		public String addEmployee(@ModelAttribute Employee emp,Model m) {
	 		/*String msg="Failed";
			if(service.saveEmployee(emp))
				 msg="Successful";
			
	 		m.addAttribute("msg",msg);
	 		return "view.jsp";
			*/
	 		Employee add=service.saveEmployee(emp);
	 		m.addAttribute("emp",emp);
	 		return "view.jsp";
						
		}
	 	
	 	@GetMapping("/employee")
	 	public String getEmployee(@RequestParam("id")int empId,Model m) {
	 		Employee emp=service.getEmployee(empId);
	 		m.addAttribute("emp",emp);
	 		return "viewemp.jsp";
	 		
	 	}
	 	
	 	@PostMapping("/update")
	 	public String updateEmp(@ModelAttribute Employee emp,@RequestParam("age")int age,@RequestParam("empName")String empName,Model m) {
	 		Employee upd=service.updEployee(emp);
	 		upd.setAge(age);
	 		upd.setEmpName(empName);
			m.addAttribute("update",upd);
	 		return "updatejs.jsp";
	 		
	 	}
	 	
	 	@GetMapping("/employees")
	 	public String getAllEmployees(Model m) {
	 		List<Employee> empList=service.getAllEmployee();
	 		m.addAttribute("empList",empList);
	 		return "viewall.jsp";
	 		
	 		
	 	
	 	}
	 	
	 	@GetMapping("/delete")
	 	public String deleteEmployee(@RequestParam("empId")int empId,Model m) {
	 		String msg="Failed";
	 		if(service.deleteEmployee(empId))
	 		
	 		 msg="Successful";
	 		m.addAttribute("msg",msg);
	 		return "view.jsp";
	 	}
	 	
	 	
}
