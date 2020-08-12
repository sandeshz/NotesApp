package com.notes.notes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class NotesModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noteId;
	

	private String noteText;
	
	private String noteTitle;
	
	public NotesModel() {
		super();
	}
	
	public NotesModel(int noteId, String noteTitle, String noteText) {
		super();
		this.noteId = noteId;
		this.noteTitle = noteTitle;
		this.noteText = noteText;
	}
	
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteText() {
		return noteText;
	}
	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}
	@Override
	public String toString() {
		return "Notes [noteId=" + noteId + ", noteTitle=" + noteTitle + ", noteText=" + noteText + "]";
	}
}