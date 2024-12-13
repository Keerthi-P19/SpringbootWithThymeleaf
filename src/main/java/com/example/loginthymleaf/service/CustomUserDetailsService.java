package com.example.loginthymleaf.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.loginthymleaf.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		com.example.loginthymleaf.model.User user = userRepository.findByUsername(username)
//				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//		return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
//				.password(user.getPassword()).roles(user.getRole()).build();
//	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.loginthymleaf.model.User user = userRepository.findByUsername(username)
	            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
	    
	    System.out.println("User authenticated: " + username); // Log for debugging

	    return org.springframework.security.core.userdetails.User
	            .withUsername(user.getUsername())
	            .password(user.getPassword())
	            .roles(user.getRole())
	            .build();
	}

}
