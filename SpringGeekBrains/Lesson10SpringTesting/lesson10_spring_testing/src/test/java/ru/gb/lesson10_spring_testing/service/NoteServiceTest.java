package ru.gb.lesson10_spring_testing.service;

import org.aspectj.lang.annotation.Before;
<<<<<<< HEAD
import org.junit.Test;
=======
>>>>>>> origin/main
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import ru.gb.lesson10_spring_testing.model.Note;
import ru.gb.lesson10_spring_testing.repository.NoteRepository;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class NoteServiceTest {
    @InjectMocks
    private NoteService noteService;
    @Mock
    private NoteRepository noteRepository;


    @Before("initializing")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

<<<<<<< HEAD

    @Test
=======
>>>>>>> origin/main
    public void getAllNotesTest() {
        Note note = new Note();
        note.setTitle("Test Title");
        note.setContent("Test Content");

        List<Note> expectedNotes = Collections.singletonList(note);
        when(noteRepository.findAll()).thenReturn(expectedNotes);

        List<Note> actualNotes = noteService.getAllNotes();
        assertEquals(expectedNotes, actualNotes);
    }

    // ...
}