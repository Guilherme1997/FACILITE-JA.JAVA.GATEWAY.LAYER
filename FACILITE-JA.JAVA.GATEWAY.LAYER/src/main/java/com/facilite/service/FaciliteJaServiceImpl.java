package com.facilite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facilite.adapter.PaymentAdapter;
import com.facilite.dto.PaymentDTO;

@Service
public class FaciliteJaServiceImpl implements FaciliteJaService {
	
	private PaymentAdapter paymentAdapter;
	
	@Autowired
	public FaciliteJaServiceImpl(PaymentAdapter paymentAdapter) {
		this.paymentAdapter = paymentAdapter;
	}

	@Override
	public void sendingPayment( PaymentDTO dto) {
		this.paymentAdapter.sendingPayment(dto);
	}
}
