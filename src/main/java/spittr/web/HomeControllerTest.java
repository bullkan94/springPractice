package spittr.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spittr.web.Home;

public class HomeControllerTest {
	@Test
	public void testHomePage() throws Exception {
		Home controller = new Home();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/"))
		.andExpect(view().name("index"));
	}
}
