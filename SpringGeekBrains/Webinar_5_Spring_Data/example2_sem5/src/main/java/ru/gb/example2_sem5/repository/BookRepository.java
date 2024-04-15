package ru.gb.example2_sem5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.example2_sem5.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
