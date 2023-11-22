package com.johncodes.student.backend.system.repository;

import com.johncodes.student.backend.system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
