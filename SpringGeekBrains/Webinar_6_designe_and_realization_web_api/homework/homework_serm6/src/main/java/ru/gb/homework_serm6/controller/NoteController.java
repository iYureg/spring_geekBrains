package ru.gb.homework_serm6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework_serm6.model.Note;
import ru.gb.homework_serm6.repository.NoteRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NoteController {
    private final NoteRepository noteRepository;
    @GetMapping("/notes")
    public ResponseEntity<Iterable<Note>> getNotes() {
        return new ResponseEntity<>(noteRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/note/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable("id") Long id) {
        Optional<Note> note = noteRepository.findById(id);
        return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/note")
    public ResponseEntity<Note> saveNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteRepository.save(note), HttpStatus.CREATED);
    }

    @PutMapping("/note/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable("id") Long id, @RequestBody Note note) {
        note.setId(id);
        return new ResponseEntity<>(noteRepository.save(note), HttpStatus.OK);
    }

    @DeleteMapping("/note/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable("id") Long id) {
        noteRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
