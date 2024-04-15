package ru.gb.example3_sem5.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    /**
     * Отношение множества курсов ко множеству студентов.
     */
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();
}
