package com.cg.tca.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "SUPERVISOR")
public class Supervisor {
	@Id
	@Column(name = "SUP_ID")
	private int supervisorId;
	@Column(name = "SUP_NAME", nullable = false)
	private String supervisorName;
	@Column(name = "SUP_PHNO", nullable = false, unique = true, length = 10)
	private String supervisorNumber;
	@Column(name = "SUP_EMAIL", nullable = false, unique = true, length = 30)
	private String supervisorEmail;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "USER_ID")
	private String userId;

}