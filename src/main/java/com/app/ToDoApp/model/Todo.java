package com.app.ToDoApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.Instant;

@Entity
public class Todo {
    @Id
    private String task;
    private Long created;
    private Long due;
    private Boolean completed;

    public Todo() {
    }

    public Todo(String task, Long due) {
        this.task = task;
        this.due = due;
        this.completed = false;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getDue() {
        return due;
    }

    public void setDue(Long due) {
        this.due = due;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public boolean isInProgress() {
        return !completed;
    }

    @PrePersist
    void prePersist() {
        this.created = Instant.now().getEpochSecond();
    }

    @Override
    public String toString() {
        return "Todo [Task=" + task + ", Created=" + created + ", Due=" + due + ", Completed=" + completed + "]";
    }
}
