package com.app.ToDoApp.controller;

import com.app.ToDoApp.dto.CreateTodoDto;
import com.app.ToDoApp.model.Todo;
import com.app.ToDoApp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TDAController {

    private final TodoService service;

    @Autowired
    public TDAController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/todos")
    public List<Todo> getAll() {
        return service.getAll();
    }

    @PostMapping("/todos/create")
    public void save(@RequestBody CreateTodoDto dto) {
        service.save(dto);
    }

    @DeleteMapping("/todos/{task}")
    public void complete(@PathVariable String task) {
        service.complete(task);
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<String> handle(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

	
