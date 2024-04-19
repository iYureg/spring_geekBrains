package ru.gb.homework_serm6.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;

    private LocalDateTime dateOfCreation;

    @PrePersist
    private void init(){
        this.dateOfCreation = LocalDateTime.now();
    }
}
