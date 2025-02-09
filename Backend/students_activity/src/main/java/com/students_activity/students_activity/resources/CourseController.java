package com.students_activity.students_activity.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.students_activity.students_activity.models.Course;

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
        new Course(7, "Música", 7));
}
