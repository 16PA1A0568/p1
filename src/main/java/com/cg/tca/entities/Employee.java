package com.cg.tca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
@Table(name="EMPLOYEE")
public class Employee{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Column(name="EMP_ID")
	private int employeeId;
	@Column(name="EMP_NAME")
	private String employeeName;
	@Column(name="EMP_ROLE")
	private String employeeRole;
	@Column(name="EMP_PHNO")
	private String phoneNumber;
	@Column(name="EMP_EMAIL")
	private String employeeEmail;
	@Column(name="PASSWORD")
	private String pass;
	@Column(name="USER_ID")
	private String userId;
	@ManyToOne
	@JoinColumn(name="SUP_ID")
	@JsonBackReference
	private Supervisor supervisor;
}
