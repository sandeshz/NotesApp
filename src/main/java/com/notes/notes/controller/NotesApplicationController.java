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

import com.notes.notes.model.NotesModel;
import com.notes.notes.service.NotesService;

@RestController
public class NotesApplicationController {
	
	static final Logger log = LoggerFactory.getLogger(NotesApplicationController.class);
	
	@Autowired
	public NotesService noteService;
	
	@CrossOrigin
	@GetMapping("/getAllNotes")
	public List<NotesModel> getListOfNotes()
	{
		List<NotesModel> notes = noteService.findAllNotes();
		log.info("All Notes retrieved");
		return notes;
	}
	
	@CrossOrigin
	@PostMapping("/saveNote")
	public String saveNotes(@RequestBody NotesModel note)
	{
		noteService.saveNote(note);
		log.info("1 Note inserted in database");
		return "Operation saveNote completed";
	}
	
	@CrossOrigin
	@PutMapping("/updateNote/{note_id}")
	public String updateNote(@RequestBody NotesModel note, @PathVariable int note_id)
	{
		noteService.updateNote(note, note_id);
		log.info("Current Note updated");
		return "Operation updateNote completed";
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteNote/{note_id}")
	public boolean deleteNote(@PathVariable int note_id)
	{
		try {
			noteService.deleteNote(note_id);
			log.info("Current Note deleted");
		}
		catch(Exception e){
			log.error("Error deleting note, requested note not available");
			return false;
		}
		return true;
	}
}
