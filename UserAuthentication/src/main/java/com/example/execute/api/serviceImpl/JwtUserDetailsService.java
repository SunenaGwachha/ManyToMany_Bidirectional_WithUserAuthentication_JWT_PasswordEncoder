package com.example.execute.api.serviceImpl;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.execute.api.model.Credentials;
import com.example.execute.api.model.User;
import com.example.execute.api.repository.CredentialRepository;
import com.example.execute.api.repository.UserRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CredentialRepository credentialRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Credentials credential = credentialRepository.findByUsername(username);

		if (credential == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

		return new org.springframework.security.core.userdetails.User(credential.getUsername(), credential.getPassword(),
				getAuthorities(credential));
	}

	private static Collection<? extends GrantedAuthority> getAuthorities(Credentials credential) {

		String[] userRoles = credential.getRoles().stream().map(x->x.getRole_name()).toArray(String[]::new);

		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);

		return authorities;

	}

	public User save(User user) {
			
		user.getCredentials().setPassword(bcryptEncoder.encode(user.getCredentials().getPassword()));
		return userRepository.save(user);
	}

}