package ru.gb.example3_sem5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.example3_sem5.domain.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
