package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
//        return Arrays.asList(new Student(1L, "Mike", "mike@gmail.com", LocalDate.of(2000, 12, 12)));
        return studentRepository.findAll();
    }

    public void add(Student student) {
        Optional<Student> optionalStudent = studentRepository.findStudentByEmail(student.getEmail());

        if (optionalStudent.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        studentRepository.save(student);
    }
}
