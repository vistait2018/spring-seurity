package com.auth.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
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
 //  hasRole, hasAnyRole, hasAuthority,hasAnyAuthority



    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN, ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents(){
        return STUDENTS;
    }

    @GetMapping(path = "{studentId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public Student getStudentById(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream()
                .filter(student->studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Student" + studentId + "doen not exists"));

    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student){
        System.out.println("New Students");
        System.out.println(student.toString());
    }

    @DeleteMapping(path="{studentId}")
    @PreAuthorize("hasAnyAuthority('student:write')")
    public void daleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println(studentId);
    }

    @PutMapping(path="{studentId}")
    @PreAuthorize("hasAnyAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId ,@RequestBody  Student student){
        System.out.println(String.format("%s %s", student,studentId));
    }

}
