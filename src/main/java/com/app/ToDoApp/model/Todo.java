package com.app.ToDoApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Todo {
    @Id
    private String task;
    private String created;
    private String due;
    private String completed;

    public String getTask() {
        return task;
    }

    public void setTask(String Task) {
        this.task = Task;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String Created) {
        this.created = Created;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String Due) {
        this.due = Due;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String Completed) {
        this.completed = Completed;
    }

    @Override
    public String toString() {
        return "Todo [Task=" + task + ", Created=" + created + ", Due=" + due + ", Completed=" + completed + "]";
    }
}
