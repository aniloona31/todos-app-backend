package com.anirudh.rest.webservices.restfulwebservices.HelloWorld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
//Controller it tells that this will control the rest services

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

	//GET
	//URI- /hellowrold
	//method "Hello World"
	//to create the mapping of the method to uri
	//request method is used to specify the  type of method that we are creating.
	@GetMapping(path="/helloworld")//similarly there are put,post etc  mapping
	public String helloWorld() {
		return "Hello World";
	}
	//whatever text is returned by this method is displayed on the brower of set path
	
	//creating a hello-world-bean and returning it
	@GetMapping(path="/helloworldbean")
	public helloWorldBean HelloWorldBean() {
		//throw new RuntimeException("Some error occuered please contact the support!!!");
		return new helloWorldBean("Hello World");
	}
	
	//passing name as path variable as a parameter to the path
	// /hello-world/path-variable/anirudh... anirudh will be mapped to name
	@GetMapping(path="/hello-world/path-variable/{name}")
	public helloWorldBean HelloWorldPathVariable(@PathVariable String name) {
		return new helloWorldBean(String.format("Hello World %s", name));
	}
	//what it did is mapped the path variable name to URI and whatever was returned by the 
	//older function only that is helloWorldBean it just formatted the return by adding 
	//name to it.
}
