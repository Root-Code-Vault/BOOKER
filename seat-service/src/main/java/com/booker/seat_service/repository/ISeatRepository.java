package com.booker.seat_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booker.seat_service.entity.Seat;

@Repository
public interface ISeatRepository extends JpaRepository<Seat, Long>{

}
