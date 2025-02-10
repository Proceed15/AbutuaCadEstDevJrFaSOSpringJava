package com.students_activity.students_activity.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.students_activity.students_activity.models.Course;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
public class CourseController {
    private List<Course> courses = Arrays.asList(
        new Course(1, "Desenvolvimento de Sistemas", 1),
        new Course(2, "Fogos de Artíficio", 2),
        new Course(3, "Psicologia", 3),
        new Course(4, "Administração", 4),
        new Course(5, "Física", 5),
        new Course(6, "Idéias", 6),
        new Course(7, "Música", 7),
        new Course(8, "Medicina", 8),
        new Course(9, "Sistemas da Informação", 9),
        new Course(10, "Linguagens", 10));

    @PostConstruct
    public void init() {
        //SI
    }
    @GetMapping("courses")
    public List<Course> getCourses(){
        return courses;
    }
    public ResponseEntity<Course> getCourse(@PathVariable int id){
        Course cs = courses.stream()
        .filter(s -> s.getId() == id)
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course Not Found"));

        return ResponseEntity.ok(cs);
    }
}
