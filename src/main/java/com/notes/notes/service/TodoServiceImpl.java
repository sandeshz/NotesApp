package com.notes.notes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.notes.notes.model.TodoModel;
import com.notes.notes.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	public TodoRepository todoRepo;

	@Override
	public List<TodoModel> findAllTodos()
	{
		return todoRepo.findAll();
	}

	@Override
	public void saveTodo(TodoModel todos)
	{
		todoRepo.save(todos);
	}
	
	@Override
	public TodoModel findByTodoId(int todo_id)
	{
		TodoModel todoObj = todoRepo.findOne(todo_id);
		return todoObj;
	}
	
	@Override
	public TodoModel updateTodo(TodoModel todos, int todo_id)
	{ 
		TodoModel todoObj = findByTodoId(todo_id);
		todoObj.setTaskText(todos.getTaskText());
		return todoRepo.save(todoObj);
	}

	@Override
	public List<TodoModel> deleteTodo(int todo_id)
	{
		todoRepo.delete(todo_id);
		return todoRepo.findAll();
	}
}
