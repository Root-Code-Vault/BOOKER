package com.booker.auth_service.service.applicationService.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.booker.auth_service.dto.AuthRequestDTO;
import com.booker.auth_service.dto.AuthResponseDTO;
import com.booker.auth_service.dto.mapper.UserMapper;
import com.booker.auth_service.entity.UserEntity;
import com.booker.auth_service.exception.EmailAlreadyExistsException;
import com.booker.auth_service.service.applicationService.IAuthApplicationService;
import com.booker.auth_service.service.componentService.IAuthComponentService;

@Service
public class AuthApplicationServiceImpl implements IAuthApplicationService {
	@Autowired
	private IAuthComponentService authComponentService;

//	@Autowired
//	private UserDetailsApplicationServiceImpl userDetailsComponentService;

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	@Override
	public AuthResponseDTO createUser(AuthRequestDTO dto) throws ParseException {
		if (dto.getEmail() != null) {
			if (authComponentService.getUserByEmail(dto.getEmail()) != null) {
				throw new EmailAlreadyExistsException("Email already present: " + dto.getEmail());
			}
		}

		UserEntity userEntity = new UserEntity();
		userEntity = UserMapper.toModel(dto);

		UserEntity savedUser = authComponentService.saveUser(userEntity);

		return UserMapper.toDTO(savedUser);
	}

	@Override
	public List<AuthResponseDTO> getAllUsers() {
		return authComponentService.getAllUsers();
	}

	@Override
	public AuthResponseDTO getUserById(Long id) {
		return authComponentService.getUserById(id);
	}
}
