package ru.gb.lesson10_spring_testing.service;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.gb.lesson10_spring_testing.model.Note;
import ru.gb.lesson10_spring_testing.repository.NoteRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteServiceIntegrationTest {
    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteRepository noteRepository;
    @Before("Clear db before starting")
    public void setUp() {
// Очищаем базу данных перед каждым тестом
        noteRepository.deleteAll();
    }
    @Test
    public void getAllNotesIntegrationTest() {
        Note note = new Note();
        note.setTitle("Integration Test Title");
        note.setContent("Integration Test Content");
        noteRepository.save(note);
        List<Note> notes = noteService.getAllNotes();
        assertTrue(notes.size() > 0);
        assertEquals(note.getTitle(), notes.get(0).getTitle());
    }

}

