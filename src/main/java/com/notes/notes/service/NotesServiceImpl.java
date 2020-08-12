package com.notes.notes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.notes.notes.model.NotesModel;
import com.notes.notes.repository.NotesRepository;

@Service
public class NotesServiceImpl implements NotesService {
	
	@Autowired
	public NotesRepository noteRepo;
	
	@Override
	public List<NotesModel> findAllNotes()
	{
		return noteRepo.findAll();
	}

	@Override
	public void saveNote(NotesModel notes)
	{
		noteRepo.save(notes);
	}

	@Override
	public NotesModel findByNoteId(int note_id)
	{
		NotesModel noteObj = noteRepo.findOne(note_id);
		return noteObj;
	}
	
	@Override
	public NotesModel updateNote(NotesModel notes, int note_id)
	{ 
		NotesModel noteObj = findByNoteId(note_id);
		noteObj.setNoteTitle(notes.getNoteTitle());
		noteObj.setNoteText(notes.getNoteText());
		return noteRepo.save(noteObj);
	}

	@Override
	public List<NotesModel> deleteNote(int note_id)
	{
		noteRepo.delete(note_id);
		return noteRepo.findAll();
	}	
}
