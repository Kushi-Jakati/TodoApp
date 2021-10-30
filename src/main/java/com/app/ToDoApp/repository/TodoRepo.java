package com.app.ToDoApp.repository;

import com.app.ToDoApp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TodoRepo extends JpaRepository<Todo, String> {

    @Transactional
    @Modifying
    @Query("""
            UPDATE Todo x
            SET x.completed = TRUE
            WHERE x.task = :task
            """)
    void completeTodo(String task);
}
