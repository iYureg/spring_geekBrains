package ru.gb.lesson10_spring_testing.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson10_spring_testing.model.Note;
import ru.gb.lesson10_spring_testing.service.NoteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    public ResponseEntity<List<Note>> getNotes(){
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id){
        try{
            return new ResponseEntity<>(noteService.getNoteById(id), HttpStatus.OK);
        } catch(RuntimeException e){
            System.out.println("Note not found with id: " + id);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
    }

    @PostMapping
    public ResponseEntity<Note> saveNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.saveOrUpdate(note), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note){
        try{
            Note noteFromDb = noteService.getNoteById(id);
            noteFromDb.setTitle(note.getTitle());
            noteFromDb.setContent(note.getContent());
            return new ResponseEntity<>(noteService.saveOrUpdate(note), HttpStatus.OK);
        } catch(RuntimeException e){
            System.out.println("Note not found with id: " + id);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
    }
}
