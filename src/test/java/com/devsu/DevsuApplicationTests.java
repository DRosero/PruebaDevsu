package com.devsu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class DevsuApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	String uri = "/DevOps";
	MvcResult mvcResult;

	@Test
	public void testErrorResponsePostJSON() throws Exception {
		String jsonToSend= "{\"message\":\"This is a test\",\"to\":\"Juan Perez\",\"from\":\"Rita Asturia\",\"timeToLifeSec\":\"45\"}";
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonToSend)).andReturn();
		assertEquals(500, mvcResult.getResponse().getStatus());
	}

	@Test
	public void testErrorJSONFormat() throws Exception {
		String jsonToSend= "This is a text string, not a JSON format";
		mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonToSend)).andReturn();
		assertEquals(400, mvcResult.getResponse().getStatus());
	}

}
