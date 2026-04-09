package com.booker.auth_service.dto.mapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.booker.auth_service.dto.AuthRequestDTO;
import com.booker.auth_service.dto.AuthResponseDTO;
import com.booker.auth_service.entity.UserEntity;

public class UserMapper {
	static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
    public static AuthResponseDTO toDTO(UserEntity user) {
        AuthResponseDTO responseDTO = new AuthResponseDTO();
        responseDTO.setId(user.getId().toString());
        responseDTO.setName(user.getName());
        responseDTO.setEmail(user.getEmail());
        
        return responseDTO;
    }

    public static UserEntity toModel(AuthRequestDTO authRequestDTO) {
    	UserEntity user = new UserEntity();
        user.setName(authRequestDTO.getName());
        user.setEmail(authRequestDTO.getEmail());
        user.setPassword(encoder.encode(authRequestDTO.getPassword()));
        
        return user;
    }
}
