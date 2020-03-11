package com.auth.student;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jyde on 3/10/2020.
 */


@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static  final List<Student> STUDENTS = Arrays.asList(
            new Student( 1,"Mike Tyson"),
            new Student( 2,"Tyler Perry"),
            new Student( 3,"Bosnia Bonder"),
            new Student( 4,"Anna Johnson")

    );

    @GetMapping
    public List<Student> getAllStudents(){
        return STUDENTS;
    }

    @GetMapping(path = "{studentId}")
    public Student getStudentById(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream()
                .filter(student->studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Student" + studentId + "doen not exists"));

    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        System.out.println(student.toString());
    }

    @DeleteMapping(path="{studentId}")
    public void daleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println(studentId);
    }

    @PutMapping(path="{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId ,@RequestBody  Student student){
        System.out.println(String.format("%s %s", student,studentId));
    }

}
