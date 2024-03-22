package com.bank.core.config.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.core.proto.pain_008_001_10.DocumentOuterClass.Document;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentInnitationController {

	
	@PostMapping(value = {"/payment"})
	public ResponseEntity<Document> innitatePayment(@RequestBody Document payment){
		
			log.debug("Payment recived "+payment.toString());
		
		return ResponseEntity.ok(payment).status(200).build();
	}
	

}
