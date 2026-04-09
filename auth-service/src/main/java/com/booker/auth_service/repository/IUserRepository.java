package com.booker.auth_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booker.auth_service.entity.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

	// List<UserEntity> findByRecordEndDateAndDeletedFlag(LocalDateTime endDate, char c);

    // AppUser findByUsername(String identifier);
}
