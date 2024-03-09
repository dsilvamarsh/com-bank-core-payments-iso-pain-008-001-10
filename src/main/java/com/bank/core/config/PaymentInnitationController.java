package com.bank.core.config;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.core.proto.PersonOuterClass.Person;

@RestController
public class PaymentInnitationController {

	
	
	
	/*
	 * @PostMapping("/debit") public ResponseEntity<String>
	 * requestDebitPayment(@RequestBody Document txnDocument){
	 * System.out.println("Document = "+txnDocument); return
	 * ResponseEntity.ok().body("Success").status(200).build();
	 * 
	 * }
	 */
	
	@GetMapping("/hello")
	public String gethello() {
		return "hello";
	}
	
	@GetMapping("/person")
	public Person getPerson() {
		return Person.newBuilder().setEmail("dsilva@gmail.com").setId(1000).setName("marsh").build();
		
	}
	
	@PostMapping(path = {"/person"})
	public ResponseEntity<Person> create(@RequestBody Person person){
		
		System.out.println(person.getEmail());
		return ResponseEntity.ok(person);
		//return  new ResponseEntity<Person>(person, HttpStatusCode.valueOf(200));
		
	}
}
