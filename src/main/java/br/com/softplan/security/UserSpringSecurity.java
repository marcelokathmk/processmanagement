package br.com.softplan.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.softplan.domain.enums.UserType;

public class UserSpringSecurity implements UserDetails{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String login;
	
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserSpringSecurity() {
	}
	
	public UserSpringSecurity(Integer id, String login, String password, Set<UserType> authorities) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.authorities = authorities.stream().map(x -> new SimpleGrantedAuthority(x.getDescriptionType())).collect(Collectors.toList());
	}
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
