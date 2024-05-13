package ru.gb.lesson10_spring_testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.lesson10_spring_testing.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
