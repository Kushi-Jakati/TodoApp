package com.app.ToDoApp.model;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<Todo, String> {
}
