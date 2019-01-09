package br.com.softplan.processManagementBackEnd;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.softplan.ProcessManagementBackEndApplication;
import br.com.softplan.domain.User;
import br.com.softplan.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProcessManagementBackEndApplication.class)
@WebAppConfiguration
public class UserTest {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private UserService userService;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void listUsersTestSucess() throws Exception {
		mockMvc.perform(get("/users"))
        	.andExpect(status().isOk())
	    	.andExpect(jsonPath("$", hasSize(4)));
	}
	
	@Test
	public void firstUserIsAdminSucess() throws Exception {
		mockMvc.perform(get("/users"))
    		.andExpect(status().isOk())
    		.andExpect(jsonPath("$[0].loginUser", is("userAdmin")));
	}
	
	@Test
	public void findUserByIdTwo() throws Exception {
		mockMvc.perform(get("/users/2"))
    		.andExpect(status().isOk())
    		.andExpect(jsonPath("$.loginUser", is("userTriador")));
	}
	
	@Test
	public void userNotFound() throws Exception {
		mockMvc.perform(get("/users/15"))
    		.andExpect(status().isNotFound());
	}
	
	@Test
	public void createUserTest() throws Exception {
		// Buscar admin
		User userCreator = userService.find(1);
		
		User user = new User(3, "userCreateTest", "abc123456", userCreator);
		
		mockMvc.perform(post("/users")
				.contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(user)))
				.andExpect(status().isCreated());
	}
}
