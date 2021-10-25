package com.app.ToDoApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Todo {
	@Id
	private String Task; 
	private String Created; 
	private String Due; 
	private String Completed;
	
	public String getTask() {
		return Task;
	}
	public void setTask(String Task) {
		this.Task = Task;
	}
	public String getCreated() {
		return Created;
	}
	public void setCreated(String Created) {
		this.Created = Created;
	}
	public String getDue() {
		return Due;
	}
	public void setDue(String Due) {
		this.Due = Due;
	}
	public String getCompleted() {
		return Completed;
	}
	public void setCompleted(String Completed) {
		this.Completed = Completed;
	}
	@Override
	public String toString() {
		return "Todo [Task=" + Task + ", Created=" + Created + ", Due=" + Due + ", Completed=" + Completed + "]";
	} 
	
}
