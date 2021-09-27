package com.anirudh.rest.webservices.restfulwebservices.todo;




import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin("http://localhost:4200/")
@RestController
public class TodoJpaResource {
	
	//@Autowired 
	//private TodoHardcodedService todoService;
	
	@Autowired
	private TodoJpaRepository todojpa;
	
	@GetMapping(path = "/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		//return todoService.findAll();
		return todojpa.findByUsername(username);
	}
	
	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public void deleteTodo(
			@PathVariable String username, @PathVariable long id){
		
		//Todo todo = todoService.deleteById(id);
		todojpa.deleteById(id);
		
		//return ResponseEntity.noContent().build();
		//return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id
			,@RequestBody Todo todo){
		todo.setUsername(username);
		Todo updatedTodo = todojpa.save(todo);
		
		return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
	}
	//to return the type and tell the request return an ok. 
	//for adding new todo.
	
	
	@PostMapping("/jpa/users/{username}/todos")
	public ResponseEntity<Void> addNewTodo(@PathVariable String username,@RequestBody Todo todo){
		todo.setUsername(username);
		Todo newTodo = todojpa.save(todo);
		//we would return the location of the place where it is stored.
		//to get the new location
		//todo.setUsername(username);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(newTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	
	@GetMapping("/jpa/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username,@PathVariable long id) {
//		Todo todo = todoService.findById(id);
		Todo todo = todojpa.findById(id).get();
		return todo;
	} 
	
	//update we need put 
	//to add new we need post
	
	
}
