package com.notes.notes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notes.notes.model.TodoModel;

@Repository
public interface TodoRepository extends JpaRepository<TodoModel, Integer>
{
	public List<TodoModel> findAll();
}
