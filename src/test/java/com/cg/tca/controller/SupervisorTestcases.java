package com.cg.tca.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cg.tca.entities.Supervisor;
import com.cg.tca.repositories.EmployeeRepository;
import com.cg.tca.repositories.SupervisorRepository;
import com.cg.tca.services.SupervisorService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(SupervisorController.class)
class SupervisorTestcases {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private SupervisorService supervisorService;
	

	@Test
	void createEmployeeTest() throws Exception {

		Supervisor e = new Supervisor();
		e.setSupervisorName("Pravallika");

		
		Mockito.when(supervisorService.createSupervisor(Mockito.any())).thenReturn(e);

		mockMvc.perform(post("/api//").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(e))).andExpect(MockMvcResultMatchers.status().isOk());
		// .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Pravallika"));
	}

	/*@Test
	void findEmployeeTest() throws Exception {

		Supervisor e = new Supervisor();
		// e.setSupervisorName("Pravallika");

		
		Mockito.when(supervisorService.getSupervisordById(Mockito.anyInt())).thenReturn(e);

		mockMvc.perform(get("/api/v1/supervisor/1")).andExpect(MockMvcResultMatchers.status().isOk());
		// .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Pravallika"));
	}*/

}
