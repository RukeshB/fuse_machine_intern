package com.junit_springboot.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class AuthorControllerTest_junit4 {

	private MockMvc mockMvc;
	
	@InjectMocks
	private AuthorController authorController;
	
	@Before
	public void init()
	{
//		authorController = new AuthorController();
		mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();
	}
	
	@Test
	public void testHello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andExpect(MockMvcResultMatchers.content().string("hello world"));
	}
	
	@Test
	public void testGetAuthorList() throws Exception
	{
//		mockMvc.perform(MockMvcRequestBuilders.get("/authors"))
//						.andExpect(MockMvcResultMatchers.status().isOk())
//						.andExpect(MockMvcResultMatchers.content())
	}

}
