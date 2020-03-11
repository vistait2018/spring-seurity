package com.auth.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jyde on 3/9/2020.
 */

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private static  final List<Student> STUDENTS = Arrays.asList(
            new Student( 1,"Mike Tyson"),
            new Student( 2,"Tyler Perry"),
            new Student( 3,"Bosnia Bonder"),
            new Student( 4,"Anna Johnson")

    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream()
                .filter(student->studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Student" + studentId + "doen not exists"));
    }
}
