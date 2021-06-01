package com.cg.tca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.tca.entities.Employee;
//import com.capgemini.entity.Attendance;
import com.cg.tca.entities.Supervisor;


@Repository
public interface SupervisorRepository extends  JpaRepository<Supervisor, Integer>  {
	//@Query("select sup from Supervisor sup where sup.employee=(select emp from Employee emp where emp.employeeId=:empId)")
	//List<Supervisor> findByEmpId(int empId);

}

