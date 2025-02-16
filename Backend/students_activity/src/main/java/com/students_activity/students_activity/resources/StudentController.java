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
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
public class StudentController {

    private List<Student> students = new ArrayList<>();
    @PostConstruct
    public void init(){
        Student S1 = new Student(1, "J", "444", "j23@gmail.com", 1, 3);
        S1.setId(1);
        S1.setName("J");
        S1.setPhone("444");
        S1.setEmail("j23@gmail.com");
        S1.setIdCourse(1);
        S1.setPeriod(3);
        Student S2 = new Student(2, "J", "222", "j23@gmail.com", 2, 3);
        S2.setId(2);
        S2.setName("J");
        S2.setPhone("222");
        S2.setEmail("j23@gmail.com");
        S2.setIdCourse(2);
        S2.setPeriod(3);
        Student S3 = new Student(3, "J", "333", "j23@gmail.com", 3, 3);
        S3.setId(3);
        S3.setName("J");
        S3.setPhone("333");
        S3.setEmail("j23@gmail.com");
        S3.setIdCourse(3);
        S3.setPeriod(3);
        Student S4 = new Student(4, "J", "111", "j23@gmail.com", 4, 3);
        S4.setId(4);
        S4.setName("J");
        S4.setPhone("111");
        S4.setEmail("j23@gmail.com");
        S4.setIdCourse(4);
        S4.setPeriod(3);
        Student S5 = new Student(5, "J", "555", "j23@gmail.com", 5, 3);
        S5.setId(5);
        S5.setName("J");
        S5.setPhone("555");
        S5.setEmail("j23@gmail.com");
        S5.setIdCourse(5);
        S5.setPeriod(3);
        Student S6 = new Student(6, "J", "666", "j23@gmail.com", 6, 3);
        S6.setId(6);
        S6.setName("J");
        S6.setPhone("666");
        S6.setEmail("j23@gmail.com");
        S6.setIdCourse(6);
        S6.setPeriod(3);
        Student S7 = new Student(7, "J", "777", "j23@gmail.com", 7, 3);
        S7.setId(7);
        S7.setName("J");
        S7.setPhone("777");
        S7.setEmail("j23@gmail.com");
        S7.setIdCourse(7);
        S7.setPeriod(3);
        Student S8 = new Student(8, "J", "888", "j23@gmail.com", 8, 3);
        S8.setId(8);
        S8.setName("J");
        S8.setPhone("888");
        S8.setEmail("j23@gmail.com");
        S8.setIdCourse(8);
        S8.setPeriod(3);
        Student S9 = new Student(9, "J", "999", "j23@gmail.com", 9, 3);
        S9.setId(9);
        S9.setName("J");
        S9.setPhone("999");
        S9.setEmail("j23@gmail.com");
        S9.setIdCourse(9);
        S9.setPeriod(3);
        Student S10 = new Student(10, "J", "1111", "j23@gmail.com", 10, 3);
        S10.setId(10);
        S10.setName("J");
        S10.setPhone("1111");
        S10.setEmail("j23@gmail.com");
        S10.setIdCourse(10);
        S10.setPeriod(3);

        students.add(S1);
        students.add(S2);
        students.add(S3);
        students.add(S4);
        students.add(S5);
        students.add(S6);
        students.add(S7);
        students.add(S8);
        students.add(S9);
        students.add(S10);
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

    //Estudantes por ID
    
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
