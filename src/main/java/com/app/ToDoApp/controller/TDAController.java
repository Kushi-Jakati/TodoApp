package com.app.ToDoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.ToDoApp.model.Todo;
import com.app.ToDoApp.model.TodoRepo;

@RestController("")
public class TDAController {
	
	@Autowired
	TodoRepo todoRepo;

	@GetMapping("/todos")
	public Iterable<Todo> todos() {
		return todoRepo.findAll(); 
		
	}
	
	//@PostMapping("/todos/create")
	//public Todo save(@RequestBody Todo todoObj) {
		//todoRepo.save(todoObj);
		//return todoObj; 
	}
	
	@DeleteMapping("/todos/{Task}")
	public String delete(@PathVariable String Task) { 

			java.util.Optional<Todo> todo = todoRepo.findById(Task);
			if(todo.isPresent()) {
				todoRepo.delete(todo.get());
				return "Task has been deleted"; 
			}
			else {
				throw new RuntimeException("Task not found."); 
			}
			}	
}

	
