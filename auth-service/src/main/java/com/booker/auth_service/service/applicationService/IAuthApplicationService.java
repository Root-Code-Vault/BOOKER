package com.booker.auth_service.service.applicationService;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.booker.auth_service.dto.AuthRequestDTO;
import com.booker.auth_service.dto.AuthResponseDTO;

@Service
public interface IAuthApplicationService {
	AuthResponseDTO createUser(AuthRequestDTO dto) throws ParseException;

	List<AuthResponseDTO> getAllUsers();

	AuthResponseDTO getUserById(Long id);
}
