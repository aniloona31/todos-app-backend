package com.anirudh.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//Controller it tells that this will control the rest services

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthenticationController {

	@GetMapping(path="/basicauth")
	public AuthenticationBean hellowroldBean() {
		return new AuthenticationBean("you are authenticated");
	}
	
	
}
