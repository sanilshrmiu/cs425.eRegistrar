package com.miu.cs.cs425.assg.eregistrar.eregistrarapp.repository;

import com.miu.cs.cs425.assg.eregistrar.eregistrarapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstNameContainingIgnoreCase(String firstName);
}

