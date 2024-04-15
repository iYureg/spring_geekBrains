package ru.gb.example2_sem5.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.example2_sem5.model.Book;
import ru.gb.example2_sem5.repository.BookRepository;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    /**
     * Получить все книги.
     * @return список всех книг в базе данных.
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Получить книгу по id.
     * @param id идентификатор нужной книги
     * @return книга если есть, иначе null
     */
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    /**
     * Сохранить новую книгу.
     * @param book книга для сохранения
     * @return сохраненная книга
     */
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * удалить книгу по id.
     * @param id идентификатор книги
     */
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    /**
     * Получить все книги с указанным автором.
     * @param id идентификатор книги
     * @param bookDetails данные для обновления книги
     * @return обновленная книга
     */
    public Book updateBook(Long id, Book bookDetails) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPublicationYear(bookDetails.getPublicationYear());
            return bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Book with id " + id + " not found");
        }
    }


}
