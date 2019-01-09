package br.com.softplan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.softplan.domain.User;
import br.com.softplan.repositories.UserRepository;
import br.com.softplan.security.UserSpringSecurity;
import br.com.softplan.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User find(Integer id) {
		User user = repository.findOne(id);
		if	(user == null) {
			throw new ObjectNotFoundException("Usuário não encontrado! id: "+ id);
		}
		return repository.findOne(id);
	}
	
	public List<User> findByTypeUser(Integer typeUser){
		return repository.findByTypeUser(typeUser);
	}
	
	public User save(User user) {
		return this.repository.save(user);
	}
	
	public void delete(Integer idUser) {
		User user = repository.findOne(idUser);
		if	(user == null) {
			throw new ObjectNotFoundException("Não foi possível excluir o usuário, id não encontrado! id: "+ idUser);
		}
		this.repository.delete(idUser);
	}
	
	public static UserSpringSecurity getUserAuthenticated() {
		try {
			return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
