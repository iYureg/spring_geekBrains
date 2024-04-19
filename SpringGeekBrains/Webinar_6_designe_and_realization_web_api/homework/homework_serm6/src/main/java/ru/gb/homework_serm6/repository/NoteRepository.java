package ru.gb.homework_serm6.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.homework_serm6.model.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
}
