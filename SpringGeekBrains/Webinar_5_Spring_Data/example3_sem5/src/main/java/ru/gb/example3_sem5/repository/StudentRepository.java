package ru.gb.example3_sem5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.example3_sem5.domain.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
