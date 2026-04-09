package com.booker.payment_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booker.payment_service.entity.Payment;

@Service
public interface IPaymentService {

	Payment initiatePayment(Payment entity, String userid);

	Payment updatePaymentStatus(Long id, String status);

	Payment getPaymentById(Long id);

	List<Payment> getPaymentsByUser(Long userId);

	Payment getFeignPaymentByBookingId(Long bookingId);

}
