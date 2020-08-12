package com.notes.notes.service;

import java.util.List;

import com.notes.notes.model.TodoModel;

public interface TodoService
{

	List<TodoModel> findAllTodos();
	public void saveTodo(TodoModel todo);
	
	public TodoModel findByTodoId(int todo_id);
	public TodoModel updateTodo(TodoModel todo, int todo_id);
	public List<TodoModel> deleteTodo(int todo_id);
}
