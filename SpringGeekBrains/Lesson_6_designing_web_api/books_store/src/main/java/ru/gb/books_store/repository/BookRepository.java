package ru.gb.books_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.books_store.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
