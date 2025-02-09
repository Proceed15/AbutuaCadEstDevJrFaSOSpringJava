package com.students_activity.students_activity.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.students_activity.students_activity.models.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
public class StudentController {

    private List<Student> students = new ArrayList<>();
    @PostConstruct
    public void init(){
        //Object[] students={'a', '1', '#'};
    }
    @PostMapping("students")
    public ResponseEntity<Student>save(@RequestBody Student student) {
        //TODO: process POST request
        student.setId(students.size()+1);
        students.add(student);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(student.getId())
        .toUri();

        return ResponseEntity.created(location).body(student);
    }
    
    @GetMapping("products/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        Student std = students.stream()
        .filter(s-> s.getId() == id)
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found"));

        return ResponseEntity.ok(std);
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        return students;
    }
}
