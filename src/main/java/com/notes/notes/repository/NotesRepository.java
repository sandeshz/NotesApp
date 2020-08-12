package com.notes.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notes.notes.model.NotesModel;

@Repository
public interface NotesRepository extends JpaRepository<NotesModel, Integer>
{
	
}
