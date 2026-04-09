package com.booker.payment_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booker.payment_service.entity.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {

	List<Payment> findAllByUserId(Long userId);

	Payment findByBookingId(Long bookingId);

}
