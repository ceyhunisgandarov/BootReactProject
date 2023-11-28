package org.learn.bootreactproject.controller;

import org.learn.bootreactproject.model.Note;
import org.learn.bootreactproject.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class NotesController {

    @Autowired
    NotesRepository notesRepo;

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> readNotes() {
        return new ResponseEntity<>(notesRepo.findAll(), HttpStatus.OK);
    }

    @PostMapping("/notes")
    public ResponseEntity<Note> saveNotes(@RequestBody Note note) {
        return new ResponseEntity<>(notesRepo.save(note), HttpStatus.CREATED);
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getSingleNote(@PathVariable Long id) {
        return new ResponseEntity<>(notesRepo.findById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<HttpStatus> deleteNote(@PathVariable Long id) {
        notesRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PutMapping("/notes/{id}")
//    public ResponseEntity<Note> editNote(@PathVariable Long id, @RequestBody Note note){
//        Note oldNote = notesRepo.findById(id).get();
//        oldNote.setTitle(note.getTitle());
//        oldNote.setBody(note.getBody());
//        oldNote.setCategory(note.getCategory());
//        return new ResponseEntity<>(notesRepo.save(oldNote), HttpStatus.OK);
//    }

    @PutMapping("/notes")
    public ResponseEntity<Note> editNote(@RequestBody Note note){
        return new ResponseEntity<>(notesRepo.save(note), HttpStatus.OK);
    }
}
