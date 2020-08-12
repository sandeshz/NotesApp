package com.notes.notes.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notes.notes.model.TodoModel;
import com.notes.notes.service.TodoService;

@RestController
public class ToDoController {
	
	static final Logger log = LoggerFactory.getLogger(ToDoController.class);

	@Autowired
	public TodoService todoService;
	
	@CrossOrigin
	@GetMapping("/getAllTodos")
	public List<TodoModel> getListOfTodos()
	{
		List<TodoModel> todos = todoService.findAllTodos();
		log.info("All Todos retrieved");
		return todos;
	}
	
	@CrossOrigin
	@PostMapping("/saveTodo")
	public String saveTodo(@RequestBody TodoModel todo)
	{
		todoService.saveTodo(todo);
		log.info("1 Todo inserted in database");
		return "Operation saveTodo completed";
	}
	
	@CrossOrigin
	@PutMapping("/updatetodo/{todo_id}")
	public String updateTodo(@RequestBody TodoModel todo, @PathVariable int todo_id)
	{
		todoService.updateTodo(todo, todo_id);
		log.info("Current Todo updated");
		return "Operation updateTodo completed";
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteTodo/{todo_id}")
	public List<TodoModel> delete(@PathVariable int todo_id)
	{
		List<TodoModel> ListOfTodos = todoService.deleteTodo(todo_id);
		log.info("Current Note deleted");
		return ListOfTodos;
	}
}
