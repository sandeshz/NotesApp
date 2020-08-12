package com.notes.notes.service;

import java.util.List;

import com.notes.notes.model.NotesModel;

public interface NotesService
{
	List<NotesModel> findAllNotes();
	public void saveNote(NotesModel note);
	public NotesModel findByNoteId(int note_id);
	public NotesModel updateNote(NotesModel note, int note_id);
	public List<NotesModel> deleteNote(int note_id);
}
