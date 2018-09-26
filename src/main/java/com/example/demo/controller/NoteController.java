package com.example.demo.controller;

import com.example.demo.repositories.Noterepository;

import com.example.demo.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by pramod-dilshan on 1/5/18.
 */

@RestController
@RequestMapping("/myapp")

public class NoteController {

    @Autowired
    Noterepository noteRepository;


    @RequestMapping(method = RequestMethod.POST, path = "/notes")
    public List<Note> getAllNotes(){
//        System.out.println("@RequestMapping(\"/notes\")");
        return noteRepository.findAll();

    }


    @RequestMapping(method = RequestMethod.POST, path = "/notesa")
    public List<Note> getAllNotes1(){
//        System.out.println("@RequestMapping(\"/notes\")");
        return noteRepository.findAll();

    }



    @PostMapping("/notes")
    public Note createNote(Note note){
//        System.out.println("@PostMapping(\"/notes\")");
        return noteRepository.save(note);
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable(value = "id") Long noteId){
        Note note = noteRepository.getOne(noteId);
        if (note == null){
            return ResponseEntity.notFound().build();

        }
        else {
            return ResponseEntity.ok().body(note);
        }
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable(value = "id") Long id, @Valid @RequestBody Note noteDetails){

//        try
//        {
//            Note note = noteRepository.getOne(id);
//        }
//        catch (Exception e)
//        {
//            System.out.println(e);
//        }
//
////        if (note == null){
////            ResponseEntity.notFound().build();
////        }
//
//        note.setTitle(noteDetails.getTitle());
//        note.setContent(noteDetails.getContent());


        Note updateNote = noteRepository.save(noteDetails);


        return ResponseEntity.ok().body(updateNote);


    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable(value = "id") Long id){
        Note note = noteRepository.getOne(id);
        if (note == null){
            ResponseEntity.notFound().build();
        }

        noteRepository.delete(note);
        return ResponseEntity.ok().build();

    }
}
