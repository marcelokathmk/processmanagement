package br.com.softplan.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.softplan.domain.User;
import br.com.softplan.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> find(@PathVariable Integer id){
		return ResponseEntity.ok().body(service.find(id));
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ResponseEntity<List<User>> findByTypeUser(@RequestParam(value="id") Integer typeUser){
		return ResponseEntity.ok().body(service.findByTypeUser(typeUser));
	}
}