package com.johncodes.student.backend.system.service;

import com.johncodes.student.backend.system.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);

    Student saveStudent(Student student);
    Student updateStudent(Student student,Long id);
    void deleteStudent(Long id);

}
