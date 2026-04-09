package com.booker.auth_service.service.componentService.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.booker.auth_service.dto.AuthResponseDTO;
import com.booker.auth_service.dto.mapper.UserMapper;
import com.booker.auth_service.entity.UserEntity;
import com.booker.auth_service.repository.IUserRepository;
import com.booker.auth_service.service.componentService.IAuthComponentService;

@Service
public class AuthComponentServiceImpl implements IAuthComponentService {
	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserEntity saveUser(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}

	@Override
	public List<AuthResponseDTO> getAllUsers() {
		return userRepository.findAll().stream().filter(Objects::nonNull).map(e -> UserMapper.toDTO(e))
				.collect(Collectors.toList());
	}

	@Override
	public AuthResponseDTO getUserById(Long userId) {
		return UserMapper.toDTO(userRepository.findById(userId)
				.orElseThrow(() -> new UsernameNotFoundException("User with ID " + userId + " not found")));
	}

	/*
	 * @Override public UserEntity getUserByUserLegacyNumber(String
	 * userLegacyNumber) {
	 * iUserRepository.findUserByUserLegacyNumber(userLegacyNumber); }
	 */

	@Override
	public void deleteUser(UserEntity userEntity) {
		userRepository.delete(userEntity);
	}

	@Override
	public UserEntity updateUser(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}

	@Override
	public UserEntity getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
