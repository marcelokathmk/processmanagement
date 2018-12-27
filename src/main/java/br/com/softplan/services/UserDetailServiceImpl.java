package br.com.softplan.services;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.softplan.domain.User;
import br.com.softplan.domain.enums.UserType;
import br.com.softplan.repositories.UserRepository;
import br.com.softplan.security.UserSpringSecurity;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = userRepository.findByLoginUser(login);
		if	(user == null) {
			throw new UsernameNotFoundException(login);
		}
		
		Set<UserType> profile = new HashSet<UserType>();
		profile.add(UserType.toEnum(user.getTypeUser()));
		
		return new UserSpringSecurity(
				user.getId(), 
				user.getLoginUser(), 
				user.getPassword(), 
				profile);
	}

}
