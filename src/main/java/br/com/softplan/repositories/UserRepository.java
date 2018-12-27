package br.com.softplan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.softplan.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Transactional(readOnly = true)
	public User findByLoginUser(String loginUser);
	
	@Transactional(readOnly = true)
	public List<User> findByTypeUser(Integer typeUser);
}
