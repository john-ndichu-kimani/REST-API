package com.johncodes.student.backend.system.controller;

import com.johncodes.student.backend.system.model.Student;
import com.johncodes.student.backend.system.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @GetMapping("/students")
    List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/student/{id}")
    Optional<Student> getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);

    }

    @PostMapping("/student")
    Student addStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @PutMapping("/update/student/{id}")
    Student updateStudent(@RequestBody Student student ,@PathVariable Long id){
        return studentService.updateStudent(student,id);
    }
    @DeleteMapping("/delete/student/{id}")
    void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

}
