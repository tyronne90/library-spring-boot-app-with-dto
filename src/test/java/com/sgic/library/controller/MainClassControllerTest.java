package com.sgic.library.controller;

import static org.junit.Assert.assertEquals;
import java.io.IOException;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;
import com.sgic.library.MainClassificationTest;
import com.sgic.library.dto.MainClassificationDTO;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = LibrarySystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainClassControllerTest extends MainClassificationTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private MainClassificationDTO mainClassificationDTO = new MainClassificationDTO();
	private String BASE_URL = "http://localhost:8081/librarysystem";
	private String ADD_API_URL = "/SaveMainClassification";
	private String GET_API_URL = "/GetAllMainClassification";
	private String PUT_API_URL = "/UpdateMainClassification";
	private String DELETE_API_URL = "/DeleteMainClassById/";
	private Long mainClassId = 1L;

//	private static final String GET_MAINCLASSIFICATION_RESPONSE = "[{\"mainClassId\":1,\"mainClassName\":\"ABC\"},{\"mainClassId\":2,\"mainClassName\":\"ABC\"}]";
	private static final String GET_MAINCLASSIFICATION_RESPONSE = "[{\"mainClassId\":1,\"mainClassName\":\"ABC\"}]";
//	private static final String GET_MAINCLASSIFICATION_RESPONSE = "[{\"mainClassId\":1,\"mainClassName\":null}]";
	private static final String PUT_MAINCLASSIFICATION_RESPONSE = "[{\"mainClassId\":1,\"mainClassName\":\"ABCD\"}]";
	private static final String DELETE_MAINCLASSIFICATION_RESPONSE = null;

//	@Before
//	public void setup() {
//		String createMainClass = "INSERT INTO librarysystem.mainclassification (main_class_name) VALUES ('ABC')";
//		jdbcTemplate.execute(createMainClass);
//	}



	// Test For Add MainClassification
	@Test
	public void addMainClassification() throws IOException, RestClientException {
		mainClassificationDTO.setMainClassName("ABC");
		HttpEntity<MainClassificationDTO> request = new HttpEntity<MainClassificationDTO>(mainClassificationDTO,
				httpHeaders);
		ResponseEntity<String> postResponse = testRestTemplate.postForEntity(BASE_URL + ADD_API_URL, request,
				String.class);
		assertEquals(200, postResponse.getStatusCodeValue());

		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + GET_API_URL, HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, getResponse.getStatusCode());
		assertEquals(GET_MAINCLASSIFICATION_RESPONSE, getResponse.getBody());
	}
	
	// Test Class for Get All MainClassification
//	@Test
//	public void getMainClassificationSuccessfull() throws IOException, RestClientException {
//		String createMainClass = "INSERT INTO librarysystem.mainclassification (main_class_name) VALUES ('ABC')";
//		jdbcTemplate.execute(createMainClass);
//		ResponseEntity<String> response = testRestTemplate.exchange(BASE_URL + GET_API_URL, HttpMethod.GET,
//				new HttpEntity<>(httpHeaders), String.class);
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		assertEquals(GET_MAINCLASSIFICATION_RESPONSE, response.getBody());
//	}

	// Test for Update MainClassification
//	@Test
//	public void UpdateMainClassification() throws IOException, RestClientException {
////		MainClassificationDTO mainClassificationDTOs = new MainClassificationDTO("ABCD");
//		mainClassificationDTO.setMainClassName("ABC");
//		HttpEntity<MainClassificationDTO> request = new HttpEntity<MainClassificationDTO>(mainClassificationDTO,
//				httpHeaders);
//		ResponseEntity<String> postResponse = testRestTemplate.postForEntity(BASE_URL + ADD_API_URL, request,
//				String.class);
//		assertEquals(200, postResponse.getStatusCodeValue());
//		
//		mainClassificationDTO.setMainClassId(1L);
//		mainClassificationDTO.setMainClassName("ABCD");
//		HttpEntity<MainClassificationDTO> updateRequest = new HttpEntity<MainClassificationDTO>(mainClassificationDTO,
//				httpHeaders);
//		ResponseEntity<String> putResponse = testRestTemplate.exchange(BASE_URL + PUT_API_URL, HttpMethod.PUT, updateRequest,
//				String.class);
//		assertEquals(202, putResponse.getStatusCodeValue());
//
//		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + GET_API_URL, HttpMethod.GET,
//				new HttpEntity<>(httpHeaders), String.class);
//		assertEquals(HttpStatus.OK, getResponse.getStatusCode());
//		assertEquals(PUT_MAINCLASSIFICATION_RESPONSE, getResponse.getBody());
//	}
	
	//	Test for Delete MAinClassification
//	@Test
//	public void DeleteMainClassification() throws IOException, RestClientException {
////		MainClassificationDTO mainClassificationDTOs = new MainClassificationDTO("ABCD");
//		mainClassificationDTO.setMainClassName("ABC");
//		HttpEntity<MainClassificationDTO> AddRequest = new HttpEntity<MainClassificationDTO>(mainClassificationDTO,
//				httpHeaders);
//		ResponseEntity<String> postResponse = testRestTemplate.postForEntity(BASE_URL + ADD_API_URL, AddRequest,
//				String.class);
//		assertEquals(200, postResponse.getStatusCodeValue());
//		
//		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + DELETE_API_URL + mainClassId,
//				HttpMethod.DELETE, new HttpEntity<>(httpHeaders), String.class);
//		assertEquals(HttpStatus.OK, getResponse.getStatusCode());
//		assertEquals(DELETE_MAINCLASSIFICATION_RESPONSE, getResponse.getBody());
//	}
//
//	@After
//	public void tearDown() {
//		String createMainClass = "DELETE FROM librarysystem.mainclassification WHERE main_class_id=1";
//		jdbcTemplate.execute(createMainClass);
//	}

}
