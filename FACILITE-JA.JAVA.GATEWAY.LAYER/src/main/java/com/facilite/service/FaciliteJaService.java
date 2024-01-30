package com.facilite.service;

import org.springframework.stereotype.Service;

import com.facilite.dto.PaymentDTO;


public interface FaciliteJaService {
	public void sendingPayment(  PaymentDTO dto);
}
