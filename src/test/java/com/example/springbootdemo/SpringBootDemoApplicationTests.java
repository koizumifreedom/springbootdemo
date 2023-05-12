package com.example.springbootdemo;

import com.example.springbootdemo.dto.Sample;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootDemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Test
	void testHello() throws Exception{
	final String API_PATH = "/hello";

	        ObjectMapper objectMapper = new ObjectMapper();

			Sample sample = new Sample();
			sample.setId(100);
			sample.setName("taro");

			this.mockMvc.perform(MockMvcRequestBuilders.get(API_PATH))
					        .andDo(MockMvcResultHandlers.print())
					        .andExpect(status().isOk())
					        .andExpect((ResultMatcher) content().json(objectMapper.writeValueAsString(sample)));
	}
}
