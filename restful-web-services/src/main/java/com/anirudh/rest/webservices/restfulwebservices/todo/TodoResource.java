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
public class TodoResource {
	
	@Autowired 
	private TodoHardcodedService todoService;
	
	@GetMapping(path = "/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return todoService.findAll();
	}
	
	@DeleteMapping(path = "/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
		Todo todo = todoService.deleteById(id);
		
		if(todo==null) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id
			,@RequestBody Todo todo){
		Todo updatedTodo = todoService.save(todo);
		
		return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
	}
	//to return the type and tell the request return an ok. 
	//for adding new todo.
	
	
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Void> addNewTodo(@PathVariable String username,@RequestBody Todo todo){
		Todo newTodo = todoService.save(todo);
		//we would return the location of the place where it is stored.
		//to get the new location
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(newTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username,@PathVariable long id) {
		Todo todo = todoService.findById(id);
		return todo;
	} 
	
	//update we need put 
	//to add new we need post
	
	
}
