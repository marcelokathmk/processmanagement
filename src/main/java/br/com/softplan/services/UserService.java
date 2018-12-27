package br.com.softplan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.softplan.domain.User;
import br.com.softplan.repositories.UserRepository;
import br.com.softplan.security.UserSpringSecurity;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User find(Integer id) {
		return repository.findOne(id);
	}
	
	public List<User> findByTypeUser(Integer typeUser){
		return repository.findByTypeUser(typeUser);
	}
	
	public static UserSpringSecurity getUserAuthenticated() {
		try {
			return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
