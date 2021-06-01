package com.cg.tca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tca.entities.Employee;
import com.cg.tca.entities.Supervisor;
import com.cg.tca.exceptions.ResourceNotFoundException;
import com.cg.tca.services.EmployeeService;
import com.cg.tca.services.SupervisorService;

//import com.capgemini.entities.Author;


@RestController
@RequestMapping("/api/v2/employees")
public class EmployeeController {
	
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private SupervisorService manServ;
	
	
	@GetMapping("/all")
	
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	@PostMapping("/")
	public Employee create(@RequestBody Employee employee) {
		return employeeService.create(employee);
		//return "employee created";
	}
	
	
	
	//@PostMapping("/CreateEmployee/{sup_id}")
	
	//public ResponseEntity<Employee> createEmployee( @RequestBody Employee employee,@PathVariable("sup_id") Integer supervisorId) throws ResourceNotFoundException {
		//Supervisor sup=manServ.getSupervisorById(supervisorId);
		//if(sup!=null)
			//employee.setSupervisor(sup);
		
		//return ResponseEntity.ok(employeeService.createEmployee(employee));
	//}
	
	@PutMapping("/{id}")
	
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer employeeId,
						@RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee  employee = employeeService.updateEmployee(employeeId, employeeDetails);
		
		return  ResponseEntity.ok(employee);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	
	public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable(value = "id") Integer employeeId)
						throws ResourceNotFoundException{
		
		return ResponseEntity.ok(employeeService.deleteEmployeeById(employeeId));
	}
	
	@GetMapping("/getById/{id}")
	
	public Employee getEmployeeById(@PathVariable(value="id")String empId) throws ResourceNotFoundException{
		
		return employeeService.getEmpById(Integer.parseInt(empId));
	}
}
