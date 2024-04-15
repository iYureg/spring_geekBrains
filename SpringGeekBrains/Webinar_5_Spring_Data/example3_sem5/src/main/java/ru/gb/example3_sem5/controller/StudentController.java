package ru.gb.example3_sem5.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.example3_sem5.domain.Course;
import ru.gb.example3_sem5.domain.Student;
import ru.gb.example3_sem5.repository.CourseRepository;
import ru.gb.example3_sem5.repository.StudentRepository;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;


    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @PostMapping("/students/{studentId}/courses/{courseId}")
    public Student addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId){
        Student student = studentRepository.findById(studentId).get(); //.orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));
        Course course = courseRepository.findById(courseId).get();  //.orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));
        student.getCourses().add(course);
        return studentRepository.save(student);
    }

}
