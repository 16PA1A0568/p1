package com.cg.tca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;

import com.cg.tca.entities.Employee;
import com.cg.tca.entities.Supervisor;
import com.cg.tca.exceptions.ResourceNotFoundException;
import com.cg.tca.repositories.EmployeeRepository;

//import com.capgemini.entities.Author;

@Service
//@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	// Logger log=Logger.getLogger(getClass());

	@Autowired
	private SupervisorService supService;

	/*
	 * public Employee createEmployee(Employee employee) throws
	 * ResourceNotFoundException { Supervisor
	 * supervisor=supService.getSupervisorById(employee.getSupervisor().
	 * getSupervisorId()); supervisor.getEmps().add(employee);
	 * supService.updateSupervisor(supervisor.getSupervisorId(),supervisor);
	 * //log.info("employee with id "+employee.getEmployeeId()+" created"); return
	 * employeeRepository.save(employee); }
	 */

	public Employee updateEmployee(Integer employeeId, Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		employee.setEmployeeName(employeeDetails.getEmployeeName());
		employee.setEmployeeEmail(employeeDetails.getEmployeeEmail());
		employee.setPhoneNumber(employeeDetails.getPhoneNumber());
		final Employee updatedEmployee = employeeRepository.save(employee);

		return updatedEmployee;
	}

	public boolean deleteEmployeeById(Integer employeeId) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);

		return true;
	}

	public List<Employee> getAllEmployee() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmpById(int empId) throws ResourceNotFoundException {
		Employee emp = employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + empId));

		return emp;
	}

	@Override
	public Employee create(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

}
