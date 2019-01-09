package br.com.softplan.processManagementBackEnd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import br.com.softplan.ProcessManagementBackEndApplication;
import br.com.softplan.domain.Procedure;
import br.com.softplan.domain.User;
import br.com.softplan.services.ProcedureService;
import br.com.softplan.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProcessManagementBackEndApplication.class)
@WebAppConfiguration
public class ProcedureTest {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProcedureService procedureService;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void createProcessTest() throws Exception {
		// Buscar usuário Triador
		User userCreator = userService.find(2);
		
		Procedure procedure = new Procedure("Processo teste", true, userCreator);
		
		mockMvc.perform(post("/procedure")
				.contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(procedure)))
				.andExpect(status().isCreated());
	}
	
	@Test
	public void addUserToProcess() throws Exception {
		// Buscar o processo 4
		Procedure procedure = procedureService.findById(4);
		// Buscar o usuário com id 4
		User user = userService.find(4);
		
		procedure.getUsers().add(user);
		
		mockMvc.perform(post("/procedure")
				.contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(procedure)))
				.andExpect(status().isCreated());
	}
	
}
