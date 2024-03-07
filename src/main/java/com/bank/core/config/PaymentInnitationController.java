package com.bank.core.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.core.payments.iso.proto.Pain8.Document;

@RestController
public class PaymentInnitationController {

	
	
	@PostMapping("/debit")
	public ResponseEntity<String> requestDebitPayment(@RequestBody Document txnDocument){
		System.out.println("Document = "+txnDocument);
		return ResponseEntity.ok().body("Success").status(200).build();
		
	}
	
	@GetMapping("/hello")
	public String gethello() {
		return "hello";
	}
}
