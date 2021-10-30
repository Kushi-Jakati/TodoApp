package com.app.ToDoApp.service;

import com.app.ToDoApp.dto.CreateTodoDto;
import com.app.ToDoApp.model.Todo;
import com.app.ToDoApp.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {

    private final TodoRepo repo;

    @Autowired
    public TodoService(TodoRepo repo) {
        this.repo = repo;
    }

    public List<Todo> getAll() {
        return repo.findAll().stream().filter(Todo::isInProgress).toList();
    }

    public void save(CreateTodoDto dto) {
        repo.saveAndFlush(new Todo(dto.task(), dto.due()));
    }

    public void complete(String task) {
        if (!repo.existsById(task)) {
            throw new NoSuchElementException("Task not found.");
        }
        repo.getById(task);
    }
}
