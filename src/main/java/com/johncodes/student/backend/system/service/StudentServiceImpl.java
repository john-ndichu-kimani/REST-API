package com.johncodes.student.backend.system.service;

import com.johncodes.student.backend.system.exception.StudentNotFoundException;
import com.johncodes.student.backend.system.model.Student;
import com.johncodes.student.backend.system.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

private final StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
       return Optional.ofNullable(studentRepository.findById(id).orElseThrow());
    }

    @Override
    public Student saveStudent(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRepository.findById(id).map(std->{
            std.setFirstname(student.getFirstname());
            std.setLastname(student.getLastname());
            std.setEmail(student.getEmail());
            std.setRegNo(student.getRegNo());
            std.setProgram(student.getProgram());
            std.setProgram(student.getProgram());
            return studentRepository.save(std);
        }).orElseThrow();




    }

    @Override
    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException("Student not found with id: "+id);
        }
    studentRepository.deleteById(id);
    }
}
