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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
public class StudentController {

    private List<Student> students = new ArrayList<>();
    @PostConstruct
    public void init(){
        Student S1 = new Student(1, "J", "444", "j23@gmail.com", 1, 4);
        S1.setId(1);
        S1.setName("J");
        S1.setPhone("444");
        S1.setEmail("j23@gmail.com");
        S1.setIdCourse(1);
        S1.setClasses(4);
        Student S2 = new Student(2, "J", "222", "j23@gmail.com", 2, 2);
        S1.setId(2);
        S1.setName("J");
        S1.setPhone("222");
        S1.setEmail("j23@gmail.com");
        S1.setIdCourse(2);
        S1.setClasses(2);
        Student S3 = new Student(3, "J", "333", "j23@gmail.com", 3, 3);
        S1.setId(3);
        S1.setName("J");
        S1.setPhone("333");
        S1.setEmail("j23@gmail.com");
        S1.setIdCourse(3);
        S1.setClasses(3);
        Student S4 = new Student(4, "J", "111", "j23@gmail.com", 4, 1);
        S1.setId(4);
        S1.setName("J");
        S1.setPhone("111");
        S1.setEmail("j23@gmail.com");
        S1.setIdCourse(4);
        S1.setClasses(1);
        Student S5 = new Student(5, "J", "555", "j23@gmail.com", 5, 5);
        S1.setId(5);
        S1.setName("J");
        S1.setPhone("555");
        S1.setEmail("j23@gmail.com");
        S1.setIdCourse(5);
        S1.setClasses(5);
        Student S6 = new Student(6, "J", "666", "j23@gmail.com", 6, 6);
        S1.setId(6);
        S1.setName("J");
        S1.setPhone("666");
        S1.setEmail("j23@gmail.com");
        S1.setIdCourse(6);
        S1.setClasses(6);
        Student S7 = new Student(7, "J", "777", "j23@gmail.com", 7, 7);
        S1.setId(7);
        S1.setName("J");
        S1.setPhone("777");
        S1.setEmail("j23@gmail.com");
        S1.setIdCourse(7);
        S1.setClasses(7);

        students.add(S1);
        students.add(S2);
        students.add(S3);
        students.add(S4);
        students.add(S5);
        students.add(S6);
        students.add(S7);
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
    
    @GetMapping("students/{id}")
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
