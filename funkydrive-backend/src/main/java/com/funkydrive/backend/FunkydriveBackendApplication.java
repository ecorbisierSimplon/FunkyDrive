package com.funkydrive.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FunkydriveBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunkydriveBackendApplication.class, args);
		System.out.println("essais");
	}

	@GetMapping("/test")
	public String test() {
		return String.format("coucou");
		
	}
}
