package com.notes.notes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class TodoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;
	
	private String taskText;

	public TodoModel() {
		super();
	}

	public TodoModel(int taskId, String taskText) {
		super();
		this.taskId = taskId;
		this.taskText = taskText;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskText() {
		return taskText;
	}

	public void setTaskText(String taskText) {
		this.taskText = taskText;
	}

	@Override
	public String toString() {
		return "TodoModel [taskId=" + taskId + ", taskText=" + taskText + "]";
	}
}
