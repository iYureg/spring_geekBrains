package ru.gb.example2_sem6.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.example2_sem6.model.Reader;
import ru.gb.example2_sem6.repository.BookRepository;
import ru.gb.example2_sem6.repository.ReaderRepository;

import java.util.List;

@RestController
@RequestMapping("/reader")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderRepository readerRepository;

    @GetMapping
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    @PostMapping
    public Reader createReader(@RequestBody Reader reader) {
        return readerRepository.save(reader);
    }
}
