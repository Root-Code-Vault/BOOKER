package com.booker.auth_service.service.applicationService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.booker.auth_service.entity.UserEntity;
import com.booker.auth_service.service.componentService.IAuthComponentService;

import io.jsonwebtoken.lang.Collections;

@Service
public class UserDetailsApplicationServiceImpl implements UserDetailsService {
	@Autowired
	private IAuthComponentService authComponentService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity appUser;

		appUser = authComponentService.getUserByEmail(email);
		
		if (appUser == null) {
			throw new UsernameNotFoundException("User not found: " + email);
		}

		return new User(appUser.getEmail(), appUser.getPassword(), Collections.emptyList());
	}
}
