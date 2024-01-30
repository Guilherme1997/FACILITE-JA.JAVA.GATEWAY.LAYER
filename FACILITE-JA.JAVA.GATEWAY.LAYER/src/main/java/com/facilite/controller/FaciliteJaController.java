package com.facilite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facilite.dto.PaymentDTO;
import com.facilite.service.FaciliteJaService;

@RestController
@RequestMapping("/facilite-ja")
public class FaciliteJaController {

	private FaciliteJaService faciliteJaService;
	
	@Autowired
	public FaciliteJaController(FaciliteJaService faciliteJaService) {
		this.faciliteJaService = faciliteJaService;
	}
    
    @PostMapping("/envio-de-pagamento")
    public ResponseEntity<?> create(@RequestBody PaymentDTO dto) {
    	try {
    		faciliteJaService.sendingPayment(dto);
    		return new ResponseEntity<>("Create Result", HttpStatus.OK);
    	} catch (Exception e) {
    		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}


