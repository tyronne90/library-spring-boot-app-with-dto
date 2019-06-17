package com.sgic.library.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;

import com.sgic.library.MainClassificationTest;

public class MainClassificationControllerTest extends MainClassificationTest{
	
	@Autowired
	  JdbcTemplate jdbcTemplate;
	  
	  @Before
	  public void setup() {
	  String createMainClass = "INSERT INTO librarysystem.mainclassification (main_class_name) VALUES ('ABC')";
	  jdbcTemplate.execute(createMainClass);
	  }
	  
	  
	  @Test
	  public void getMainClassificationSuccessfull() throws IOException, RestClientException {
	    ResponseEntity<String> response =
	        testRestTemplate.exchange("http://localhost:8081/librarysystem" + "/GetAllMainClassification", HttpMethod.GET,
	            new HttpEntity<>(httpHeaders), String.class);
	    assertEquals(HttpStatus.OK, response.getStatusCode());
	   }
	    
	  
	  @After
	  public void tearDown() {}
	  
	  public final class MainClassificationConstant{
	    
	    public MainClassificationConstant() {}
	    
	    @SuppressWarnings("unused")
		private static final String MAINCLASSIFICATION_RESPONSE =
	    		"[ { \\\"mainClassId\\\": 2, \\\"mainClassName\\\": \\\"Maths\\\" }, { \\\"mainClassId\\\": 36, \\\"mainClassName\\\": \\\"ABCD\\\" } ]";
	  }
}
