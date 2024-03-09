package com.bank.core.config;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.bank.core.proto.PersonOuterClass.Person;


@SpringBootTest
class ApplicationTests {

	
	@Autowired
	private RestTemplate client;
	private static final String personUrl="http://localhost:8080/person";
	@Test
	void contextLoads() {
		ResponseEntity<Person> p = client.getForEntity(personUrl, Person.class);
		System.out.println(p.getBody().getEmail());
		System.out.println(p.getBody().getName());
		System.out.println(p.getBody().getId());
	}

}
