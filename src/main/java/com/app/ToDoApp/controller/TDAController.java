package com.app.ToDoApp.controller;

import com.app.ToDoApp.model.Todo;
import com.app.ToDoApp.model.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TDAController {

    private final TodoRepo todoRepo;

	@Autowired
	public TDAController(TodoRepo todoRepo) {
		this.todoRepo = todoRepo;
	}

	@GetMapping("/todos")
    public List<Todo> todos() {
        return todoRepo.findAll();
    }

    @PostMapping("/todos/create")
    public Todo save(@RequestBody Todo todoObj) {
        todoRepo.save(todoObj);
        return todoObj;
    }

    @DeleteMapping("/todos/{task}")
    public String delete(@PathVariable String task) {

		if (!todoRepo.existsById(task)) {
			throw new RuntimeException("Task not found.");
		}

		todoRepo.deleteById(task);
		return "Task has been deleted";
    }
}

	
