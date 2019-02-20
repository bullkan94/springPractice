
package spring.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import spring.web.Home;

public class HomeControllerTest {
	@Test
	public void testHomePage() throws Exception {
		Home controller = new Home();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/get/?t=3"));
	}
}
