package com.cg.tca.services;

import java.util.List;

import com.cg.tca.entities.Employee;
import com.cg.tca.entities.Supervisor;
import com.cg.tca.exceptions.ResourceNotFoundException;

public interface SupervisorService {
	Supervisor createSupervisor(Supervisor supervisor);
	
	boolean deleteSupervisor(Integer supervisorId) throws ResourceNotFoundException;
	List<Supervisor> getAllSupervisor();
	
	Supervisor getSupervisordById(int supervisorId) throws ResourceNotFoundException;
	Supervisor updateSupervisor(Integer supervisorId, Supervisor supervisorDetails) throws ResourceNotFoundException;
	
	 
}
