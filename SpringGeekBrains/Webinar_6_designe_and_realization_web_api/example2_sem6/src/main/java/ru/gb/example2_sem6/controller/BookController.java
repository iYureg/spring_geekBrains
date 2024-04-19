package ru.gb.example2_sem6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.example2_sem6.model.Book;
import ru.gb.example2_sem6.model.Reader;
import ru.gb.example2_sem6.repository.BookRepository;
import ru.gb.example2_sem6.repository.ReaderRepository;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}/reader/{readerId}")
    public ResponseEntity<Book> assignReaderToBook(@PathVariable("id") Long id, @PathVariable("readerId") Long readerId) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        Optional<Reader> readerOptional = readerRepository.findById(readerId);

        if (bookOptional.isPresent() && readerOptional.isPresent()) {
            Book book = bookOptional.get();
            Reader reader = readerOptional.get();
            book.setReader(reader);
            bookRepository.save(book);
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            bookRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
