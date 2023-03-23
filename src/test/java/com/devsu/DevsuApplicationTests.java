package com.devsu;

import com.devsu.controller.MessageController;
import com.devsu.model.MessageDevsu;
import com.devsu.properties.ProjectDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.restassured.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest
class DevsuApplicationTests {

	@Test
	void contextLoads() {
	}

}
